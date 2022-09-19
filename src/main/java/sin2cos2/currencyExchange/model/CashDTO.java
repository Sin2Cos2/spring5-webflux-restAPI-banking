package sin2cos2.currencyExchange.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
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
