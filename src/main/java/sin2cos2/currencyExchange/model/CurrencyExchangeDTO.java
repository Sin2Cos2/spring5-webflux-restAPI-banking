package sin2cos2.currencyExchange.model;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CurrencyExchangeDTO {

    private BigDecimal receivedAmount;
    private String receivedCurrency;
    private BigDecimal releasedAmount;
    private String releasedCurrency;
    private BigDecimal rate;
    private String staff;
    private Long cashDeskId;
    private LocalDateTime date;
}
