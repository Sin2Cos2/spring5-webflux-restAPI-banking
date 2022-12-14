package sin2cos2.currencyExchange.domain;

import lombok.*;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cash {

    @Id
    private Long id;
    private String currency;
    private Long cashDeskId;
    private BigDecimal cash;
    private LocalDateTime date;
}
