package sin2cos2.currencyExchange.domain;

import lombok.*;
import org.springframework.data.annotation.Id;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Staff {

    @Id
    private long id;
    private String name;
}
