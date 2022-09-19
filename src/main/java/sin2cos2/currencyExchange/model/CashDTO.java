package sin2cos2.currencyExchange.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class CashDTO {

    private String currency;
    private Long cashDeskId;
    private BigDecimal cash;
    private LocalDateTime date;
}
