package sin2cos2.currencyExchange.services;

import reactor.core.publisher.Mono;
import sin2cos2.currencyExchange.domain.Staff;

public interface StaffService {
    Mono<Staff> findByName(String staff);
}
