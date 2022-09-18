package sin2cos2.currencyExchange.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import sin2cos2.currencyExchange.domain.CurrencyRate;
import sin2cos2.currencyExchange.mappers.CurrencyRateMapper;
import sin2cos2.currencyExchange.model.CurrencyRateDTO;
import sin2cos2.currencyExchange.repositories.CurrencyRateRepository;

import java.time.LocalDate;

@RequiredArgsConstructor
@Service
public class CurrencyRateServiceImpl implements CurrencyRateService {

    private final CurrencyRateRepository currencyRateRepository;
    private final CurrencyRateMapper currencyRateMapper = CurrencyRateMapper.INSTANCE;
    private final CurrencyDictionaryService currencyDictionaryService;

    @Override
    public Mono<CurrencyRateDTO> save(CurrencyRateDTO currencyRateDTO) {
        return currencyDictionaryService
                .findByAbbreviation(currencyRateDTO.getCurrencyAbbreviation())
                .flatMap(currency -> {
                    CurrencyRate currencyRate = currencyRateMapper
                            .currencyRateDtoToCurrencyRate(currencyRateDTO, currency.getId());

                    return currencyRateRepository.save(currencyRate)
                            .map(currRate -> currencyRateMapper
                                    .currencyRateToCurrencyRateDTO(currRate, currency.getAbbreviation()));
                });
    }

    @Override
    public Mono<CurrencyRateDTO> getCurrencyRateByCurrency(Long currencyId) {

        Mono<CurrencyRate> currencyRate = currencyRateRepository
                .findByCurrencyIdAndDate(currencyId, LocalDate.now());

        return currencyRate
                .flatMap(currRate -> currencyDictionaryService
                        .findById(currencyId)
                        .map(currency -> currencyRateMapper
                                .currencyRateToCurrencyRateDTO(currRate, currency.getAbbreviation())));
    }
}
