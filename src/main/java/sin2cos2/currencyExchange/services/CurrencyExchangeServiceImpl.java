package sin2cos2.currencyExchange.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;
import sin2cos2.currencyExchange.domain.CurrencyExchange;
import sin2cos2.currencyExchange.domain.Staff;
import sin2cos2.currencyExchange.exceptions.IllegalTransactionException;
import sin2cos2.currencyExchange.api.v1.mappers.CurrencyExchangeMapper;
import sin2cos2.currencyExchange.api.v1.model.CurrencyExchangeDTO;
import sin2cos2.currencyExchange.repositories.CurrencyExchangeRepository;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
@Slf4j
public class CurrencyExchangeServiceImpl implements CurrencyExchangeService {

    private final CurrencyExchangeRepository currencyExchangeRepository;
    private final CurrencyExchangeMapper currencyExchangeMapper = CurrencyExchangeMapper.INSTANCE;
    private final StaffService staffService;
    private final CashService cashService;

    @Transactional
    @Override
    public Mono<CurrencyExchangeDTO> saveNewTransaction(CurrencyExchangeDTO currencyExchangeDTO) {

        if (!currencyExchangeDTO.getReceivedCurrency().equalsIgnoreCase("mdl")
                && !currencyExchangeDTO.getReleasedCurrency().equalsIgnoreCase("mdl")) {
            throw new IllegalTransactionException("One of currencies should be MDL!");
        }

        //TODO: If staffMono is empty, result is not written in currency_exchange,
        // but cashService transaction is executed
        Mono<Staff> staffMono = staffService.findByName(currencyExchangeDTO.getStaff());

        //TODO: In case of wrong cashDeskId, no changes are made in database, but HTTP status is 200
        return cashService.withdrawAndDeposit(currencyExchangeDTO)
                .flatMap(result -> {

                    // Checking if the transaction was successful. If it was not, it throws an exception.
                    if (result.getId() == null)
                        return Mono.error(new IllegalTransactionException
                                ("At the moment we do not have the required amount"));

                    // Saving the transaction in the database.
                    return staffMono.flatMap(staff -> {
                                CurrencyExchange currencyExchange = currencyExchangeMapper
                                        .currencyExchangeDtoToCurrencyExchange(currencyExchangeDTO, staff.getId());
                                currencyExchange.setDate(LocalDateTime.now());

                                return currencyExchangeRepository.save(currencyExchange)
                                        .map(savedCurrencyExchange -> currencyExchangeMapper
                                                .currencyExchangeToCurrencyExchangeDTO(savedCurrencyExchange, staff.getName()));
                            })
                            .switchIfEmpty(Mono.just(new CurrencyExchangeDTO()));
                })
                .switchIfEmpty(Mono.just(new CurrencyExchangeDTO()));
    }
}
