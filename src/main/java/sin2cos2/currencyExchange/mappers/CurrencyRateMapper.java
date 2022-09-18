package sin2cos2.currencyExchange.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import sin2cos2.currencyExchange.domain.CurrencyRate;
import sin2cos2.currencyExchange.model.CurrencyRateDTO;

@Mapper
public interface CurrencyRateMapper {

    CurrencyRateMapper INSTANCE = Mappers.getMapper(CurrencyRateMapper.class);

    CurrencyRate currencyRateDtoToCurrencyRate(CurrencyRateDTO currencyRateDTO);

    CurrencyRateDTO currencyRateToCurrencyRateDTO(CurrencyRate currencyRate);
}
