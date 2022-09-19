package sin2cos2.currencyExchange.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
