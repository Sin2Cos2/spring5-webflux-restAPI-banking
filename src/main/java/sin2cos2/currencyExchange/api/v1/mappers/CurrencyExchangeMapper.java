package sin2cos2.currencyExchange.api.v1.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import sin2cos2.currencyExchange.domain.CurrencyExchange;
import sin2cos2.currencyExchange.api.v1.model.CurrencyExchangeDTO;

@Mapper
public interface CurrencyExchangeMapper {

    CurrencyExchangeMapper INSTANCE = Mappers.getMapper(CurrencyExchangeMapper.class);

    @Mapping(source = "employeeName", target = "staff")
    CurrencyExchangeDTO currencyExchangeToCurrencyExchangeDTO(CurrencyExchange currencyExchange, String employeeName);

    @Mapping(target = "id", ignore = true)
    @Mapping(source = "employeeId", target = "staffId")
    CurrencyExchange currencyExchangeDtoToCurrencyExchange(CurrencyExchangeDTO currencyExchangeDTO, Long employeeId);
}
