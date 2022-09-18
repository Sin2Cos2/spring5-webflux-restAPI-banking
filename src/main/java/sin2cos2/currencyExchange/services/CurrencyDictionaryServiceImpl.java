package sin2cos2.currencyExchange.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import sin2cos2.currencyExchange.domain.CurrencyDictionary;
import sin2cos2.currencyExchange.repositories.CurrencyDictionaryRepository;

@RequiredArgsConstructor
@Service
public class CurrencyDictionaryServiceImpl implements CurrencyDictionaryService {

    private final CurrencyDictionaryRepository currencyDictionaryRepository;

    @Override
    public Mono<CurrencyDictionary> findById(Long currencyId) {
        return currencyDictionaryRepository.findById(currencyId);
    }

    @Override
    public Mono<CurrencyDictionary> findByAbbreviation(String currencyAbbreviation) {
        return currencyDictionaryRepository.findByAbbreviation(currencyAbbreviation);
    }
}
