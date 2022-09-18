package sin2cos2.currencyExchange.services;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import sin2cos2.currencyExchange.model.CurrencyRateDTO;

public interface CurrencyRateService {
    Mono<CurrencyRateDTO> save(CurrencyRateDTO currencyRateDTO);

    Flux<CurrencyRateDTO> getCurrencyRateByCurrency(String currencyAbbreviation);
}
