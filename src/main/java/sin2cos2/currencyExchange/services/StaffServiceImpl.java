package sin2cos2.currencyExchange.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import sin2cos2.currencyExchange.domain.Staff;
import sin2cos2.currencyExchange.repositories.StaffRepository;

@RequiredArgsConstructor
@Service
public class StaffServiceImpl implements StaffService {

    private final StaffRepository staffRepository;

    @Override
    public Mono<Staff> findByName(String staff) {
        return staffRepository.findByName(staff);
    }
}
