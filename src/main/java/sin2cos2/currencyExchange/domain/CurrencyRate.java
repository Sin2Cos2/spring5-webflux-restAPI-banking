package sin2cos2.currencyExchange.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table("currency_rate")
public class CurrencyRate {

    @Id
    private Long id;
    private Long ratio;
    private BigDecimal rate;
    @Column("currency_id")
    private Long currencyDictionaryId;
    private LocalDate date;
}
