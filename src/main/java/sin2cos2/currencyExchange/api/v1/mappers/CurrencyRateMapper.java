package sin2cos2.currencyExchange.api.v1.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import sin2cos2.currencyExchange.domain.CurrencyRate;
import sin2cos2.currencyExchange.api.v1.model.CurrencyRateDTO;

@Mapper
public interface CurrencyRateMapper {

    CurrencyRateMapper INSTANCE = Mappers.getMapper(CurrencyRateMapper.class);

    @Mapping(target = "id", ignore = true)
    CurrencyRate currencyRateDtoToCurrencyRate(CurrencyRateDTO currencyRateDTO);

    CurrencyRateDTO currencyRateToCurrencyRateDTO(CurrencyRate currencyRate);
}
