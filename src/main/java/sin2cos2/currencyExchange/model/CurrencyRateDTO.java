package sin2cos2.currencyExchange.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CurrencyRateDTO {

    @Schema(required = true)
    @Min(1)
    private Long ratio;

    @Schema(required = true)
    @DecimalMin("0.01")
    private BigDecimal rate;

    @Schema(required = true)
    @Size(min = 3, max = 3)
    private String currency;

    private LocalDate date;
}
