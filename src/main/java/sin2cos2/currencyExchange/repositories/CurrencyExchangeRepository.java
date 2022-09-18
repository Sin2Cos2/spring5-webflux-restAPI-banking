package sin2cos2.currencyExchange.repositories;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import sin2cos2.currencyExchange.domain.CurrencyExchange;

public interface CurrencyExchangeRepository extends ReactiveCrudRepository<CurrencyExchange, Long> {
}
