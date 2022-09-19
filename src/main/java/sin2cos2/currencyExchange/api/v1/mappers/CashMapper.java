package sin2cos2.currencyExchange.api.v1.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import sin2cos2.currencyExchange.domain.Cash;
import sin2cos2.currencyExchange.api.v1.model.CashDTO;

@Mapper
public interface CashMapper {

    CashMapper INSTANCE = Mappers.getMapper(CashMapper.class);

    CashDTO cashToCashDTO(Cash cash);

    @Mapping(target = "id", ignore = true)
    Cash cashDtoToCash(CashDTO cashDTO);
}
