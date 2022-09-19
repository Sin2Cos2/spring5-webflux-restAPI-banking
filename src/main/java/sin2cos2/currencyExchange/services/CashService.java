package sin2cos2.currencyExchange.services;

import reactor.core.publisher.Mono;
import sin2cos2.currencyExchange.domain.Cash;
import sin2cos2.currencyExchange.model.CashDTO;
import sin2cos2.currencyExchange.model.CurrencyExchangeDTO;


public interface CashService {

    Mono<Cash> withdrawAndDeposit(CurrencyExchangeDTO currencyExchangeDTO);

    Mono<CashDTO> updateCash(CashDTO cashDTO);
}
