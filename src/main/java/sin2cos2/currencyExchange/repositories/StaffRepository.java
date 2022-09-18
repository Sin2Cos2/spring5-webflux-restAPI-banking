package sin2cos2.currencyExchange.repositories;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import sin2cos2.currencyExchange.domain.Staff;

public interface StaffRepository extends ReactiveCrudRepository<Staff, Long> {
}
