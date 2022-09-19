package sin2cos2.currencyExchange.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import sin2cos2.currencyExchange.domain.Cash;
import sin2cos2.currencyExchange.api.v1.mappers.CashMapper;
import sin2cos2.currencyExchange.api.v1.model.CashDTO;
import sin2cos2.currencyExchange.api.v1.model.CurrencyExchangeDTO;
import sin2cos2.currencyExchange.repositories.CashRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@RequiredArgsConstructor
@Service
@Slf4j
public class CashServiceImpl implements CashService {

    private final CashRepository cashRepository;
    private final CashMapper cashMapper = CashMapper.INSTANCE;

    @Override
    public Mono<Cash> withdrawAndDeposit(CurrencyExchangeDTO currencyExchangeDTO) {
        Long cashDeskId = currencyExchangeDTO.getCashDeskId();
        String releasedCurrency = currencyExchangeDTO.getReleasedCurrency();
        String receivedCurrency = currencyExchangeDTO.getReceivedCurrency();
        BigDecimal releasedAmount = currencyExchangeDTO.getReleasedAmount();
        BigDecimal receivedAmount = currencyExchangeDTO.getReceivedAmount();

        return cashRepository.findByCashDeskIdAndCurrency(cashDeskId, releasedCurrency)
                .flatMap(cash -> {
                    // Checking if the cash desk has enough money to make the transaction.
                    if (cash.getCash().compareTo(releasedAmount) < 0) {
                        return Mono.just(new Cash());
                    }

                    // Subtracting the released amount from the cash desk and saving it to the database.
                    cash.setCash(cash.getCash().subtract(releasedAmount));
                    cash.setDate(cash.getDate() == null ? LocalDateTime.now() : cash.getDate());

                    return cashRepository.save(cash);
                })
                .flatMap(cash -> {
                    // If the cash desk doesn't have enough money to make the transaction, the `withdrawAndDeposit` method
                    // returns an empty `Cash` object.
                    if (cash.getId() == null)
                        return Mono.just(new Cash());

                    // Adding the received amount to the cash desk and saving it to the database.
                    return cashRepository.findByCashDeskIdAndCurrency(cashDeskId, receivedCurrency)
                            .flatMap(cashDeposit -> {
                                cashDeposit.setCash(cashDeposit.getCash().add(receivedAmount));
                                cash.setDate(cash.getDate() == null ? LocalDateTime.now() : cash.getDate());

                                return cashRepository.save(cashDeposit);
                            });
                });
    }

    @Override
    public Mono<CashDTO> updateCash(CashDTO cashDTO) {
        Cash cash = cashMapper.cashDtoToCash(cashDTO);

        // If the cash desk doesn't have the currency, the `findByCashDeskIdAndCurrency` method returns an empty `Mono`.
        // The `switchIfEmpty` method replaces the empty `Mono` with a `Mono` that contains a new `Cash` object.
        return cashRepository
                .findByCashDeskIdAndCurrency(cash.getCashDeskId(), cash.getCurrency())
                .switchIfEmpty(Mono.just(new Cash()))
                .flatMap(oldCash -> {
                    cash.setId(oldCash.getId());
                    cash.setDate(cash.getDate() == null ? LocalDateTime.now() : cash.getDate());

                    return cashRepository.save(cash)
                            .map(cashMapper::cashToCashDTO);
                });
    }

}
