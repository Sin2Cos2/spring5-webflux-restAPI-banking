package sin2cos2.currencyExchange.repositories;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;
import sin2cos2.currencyExchange.domain.Cash;

public interface CashRepository extends ReactiveCrudRepository<Cash, Long> {
    Mono<Cash> findByCashDeskIdAndCurrency(Long cashDeskId, String currency);
}
