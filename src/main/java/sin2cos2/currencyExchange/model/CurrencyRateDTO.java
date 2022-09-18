package sin2cos2.currencyExchange.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyRateDTO {

    private Long ratio;
    private BigDecimal rate;
    private String currency;
    private LocalDate date = LocalDate.now();
}
