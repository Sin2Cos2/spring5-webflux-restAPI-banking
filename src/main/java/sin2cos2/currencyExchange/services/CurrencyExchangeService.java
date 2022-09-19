package sin2cos2.currencyExchange.services;

import reactor.core.publisher.Mono;
import sin2cos2.currencyExchange.api.v1.model.CurrencyExchangeDTO;

public interface CurrencyExchangeService {
    Mono<CurrencyExchangeDTO> saveNewTransaction(CurrencyExchangeDTO currencyExchangeDTO);
}
