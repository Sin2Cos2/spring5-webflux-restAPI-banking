package sin2cos2.currencyExchange.domain;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table("currency_rate")
public class CurrencyRate {

    @Id
    private Long id;
    private Long ratio;
    private BigDecimal rate;
    private String currency;
    private LocalDate date;
}
