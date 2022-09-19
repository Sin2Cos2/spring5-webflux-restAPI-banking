package sin2cos2.currencyExchange.services;

import reactor.core.publisher.Mono;
import sin2cos2.currencyExchange.model.CurrencyExchangeDTO;

public interface CurrencyExchangeService {
    Mono<CurrencyExchangeDTO> saveNewTransaction(CurrencyExchangeDTO currencyExchangeDTO);
}
