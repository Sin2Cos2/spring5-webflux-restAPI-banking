package sin2cos2.currencyExchange.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CurrencyExchange {

    @Id
    private long id;
    private BigDecimal receivedAmount;
    private String receivedCurrency;
    private BigDecimal releasedAmount;
    private String releasedCurrency;
    private BigDecimal rate;
    private Staff staff;
    private CashDesk cashDesk;
    private LocalDateTime date;
}
