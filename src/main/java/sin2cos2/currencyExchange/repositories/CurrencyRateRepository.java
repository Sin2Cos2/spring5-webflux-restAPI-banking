package sin2cos2.currencyExchange.repositories;

import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;
import sin2cos2.currencyExchange.domain.CurrencyRate;

import java.time.LocalDate;

public interface CurrencyRateRepository extends ReactiveCrudRepository<CurrencyRate, Long> {

    @Query("SELECT * FROM currency_rate as cr WHERE cr.currency_dictionary_id = :currencyId AND cr.date = :now")
    Mono<CurrencyRate> findByCurrencyIdAndDate(Long currencyId, LocalDate now);
}
