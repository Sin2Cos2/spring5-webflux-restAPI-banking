package sin2cos2.currencyExchange.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import sin2cos2.currencyExchange.domain.CurrencyRate;
import sin2cos2.currencyExchange.api.v1.mappers.CurrencyRateMapper;
import sin2cos2.currencyExchange.api.v1.model.CurrencyRateDTO;
import sin2cos2.currencyExchange.repositories.CurrencyRateRepository;

import java.time.LocalDate;

@RequiredArgsConstructor
@Service
public class CurrencyRateServiceImpl implements CurrencyRateService {

    private final CurrencyRateRepository currencyRateRepository;
    private final CurrencyRateMapper currencyRateMapper = CurrencyRateMapper.INSTANCE;

    @Override
    public Mono<CurrencyRateDTO> save(CurrencyRateDTO currencyRateDTO) {
        currencyRateDTO.setDate(currencyRateDTO.getDate() == null ? LocalDate.now() : currencyRateDTO.getDate());

        CurrencyRate currencyRate = currencyRateMapper.currencyRateDtoToCurrencyRate(currencyRateDTO);
        return currencyRateRepository
                .save(currencyRate)
                .map(currencyRateMapper::currencyRateToCurrencyRateDTO);
    }

    @Override
    public Flux<CurrencyRateDTO> getCurrencyRateByCurrency(String currencyAbbreviation) {

        return currencyRateRepository
                .findByCurrencyAndDate(currencyAbbreviation, LocalDate.now())
                .map(currencyRateMapper::currencyRateToCurrencyRateDTO)
                .switchIfEmpty(Flux.empty());
    }
}
