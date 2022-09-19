package sin2cos2.currencyExchange.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import sin2cos2.currencyExchange.model.CashDTO;
import sin2cos2.currencyExchange.services.CashService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/cash")
public class CashController {

    private final CashService cashService;

    @PutMapping()
    public Mono<CashDTO> updateCashInCashDesk(@RequestBody CashDTO cashDTO) {
        return cashService.updateCash(cashDTO);
    }
}
