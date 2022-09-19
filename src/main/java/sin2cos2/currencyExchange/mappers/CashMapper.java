package sin2cos2.currencyExchange.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import sin2cos2.currencyExchange.domain.Cash;
import sin2cos2.currencyExchange.model.CashDTO;

@Mapper
public interface CashMapper {

    CashMapper INSTANCE = Mappers.getMapper(CashMapper.class);

    CashDTO cashToCashDTO(Cash cash);

    Cash cashDtoToCash(CashDTO cashDTO);
}
