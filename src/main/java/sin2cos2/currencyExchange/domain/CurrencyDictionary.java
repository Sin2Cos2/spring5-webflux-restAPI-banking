package sin2cos2.currencyExchange.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CurrencyDictionary {

    @Id
    private String abbreviation;
    private String currency;
}
