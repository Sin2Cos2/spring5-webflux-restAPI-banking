package sin2cos2.currencyExchange.repositories;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;
import sin2cos2.currencyExchange.domain.CurrencyDictionary;

public interface CurrencyDictionaryRepository extends ReactiveCrudRepository<CurrencyDictionary, Long> {

    Mono<CurrencyDictionary> findByAbbreviation(String currencyAbbreviation);
}
