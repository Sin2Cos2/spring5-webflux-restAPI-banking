package sin2cos2.currencyExchange.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import sin2cos2.currencyExchange.domain.CurrencyExchange;
import sin2cos2.currencyExchange.model.CurrencyExchangeDTO;

@Mapper
public interface CurrencyExchangeMapper {

    CurrencyExchangeMapper INSTANCE = Mappers.getMapper(CurrencyExchangeMapper.class);

    @Mapping(source = "employeeName", target = "staff")
    CurrencyExchangeDTO currencyExchangeToCurrencyExchangeDTO(CurrencyExchange currencyExchange, String employeeName);

    @Mapping(source = "employeeId", target = "staffId")
    CurrencyExchange currencyExchangeDtoToCurrencyExchange(CurrencyExchangeDTO currencyExchangeDTO, Long employeeId);
}