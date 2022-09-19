package sin2cos2.currencyExchange.api.v1.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CashDTO {

    @Schema(required = true)
    @Size(min = 3, max = 3)
    private String currency;

    @Schema(required = true)
    @Min(1)
    private Long cashDeskId;

    @Schema(required = true)
    @Min(1)
    private BigDecimal cash;

    private LocalDateTime date;
}
