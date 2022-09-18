package sin2cos2.currencyExchange.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;
import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Cash {

    @Id
    private Long id;
    private Long currencyDictionaryId;
    private Long cashDeskId;
    private BigDecimal cash;
    private LocalDate date;
}
