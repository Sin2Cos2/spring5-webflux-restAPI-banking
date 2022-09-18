package sin2cos2.currencyExchange.services;

import reactor.core.publisher.Mono;
import sin2cos2.currencyExchange.domain.CurrencyDictionary;

public interface CurrencyDictionaryService {

    Mono<CurrencyDictionary> findById(Long currencyId);

    Mono<CurrencyDictionary> findByAbbreviation(String currencyAbbreviation);
}
