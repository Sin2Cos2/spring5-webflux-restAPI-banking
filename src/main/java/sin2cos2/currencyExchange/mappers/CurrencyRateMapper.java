package sin2cos2.currencyExchange.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import sin2cos2.currencyExchange.domain.CurrencyRate;
import sin2cos2.currencyExchange.model.CurrencyRateDTO;

@Mapper
public interface CurrencyRateMapper {

    CurrencyRateMapper INSTANCE = Mappers.getMapper(CurrencyRateMapper.class);

    @Mapping(source = "currencyDictionaryId", target = "currencyDictionaryId")
    CurrencyRate currencyRateDtoToCurrencyRate(CurrencyRateDTO currencyRateDTO, Long currencyDictionaryId);

    @Mapping(source = "currencyAbbreviation", target = "currencyAbbreviation")
    CurrencyRateDTO currencyRateToCurrencyRateDTO(CurrencyRate currencyRate, String currencyAbbreviation);
}
