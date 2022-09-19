package sin2cos2.currencyExchange.api.v1.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CurrencyExchangeDTO {

    @Schema(required = true)
    @Min(1)
    private BigDecimal receivedAmount;

    @Schema(required = true)
    @Size(min = 3, max = 3)
    private String receivedCurrency;

    @Schema(required = true)
    @Min(1)
    private BigDecimal releasedAmount;

    @Schema(required = true)
    @Size(max = 3, min = 3)
    private String releasedCurrency;

    @Schema(required = true)
    @DecimalMin("0.01")
    private BigDecimal rate;

    @Schema(required = true)
    @Size(min = 2)
    private String staff;

    @Schema(required = true)
    @Min(1)
    private Long cashDeskId;

    private LocalDateTime date;
}
