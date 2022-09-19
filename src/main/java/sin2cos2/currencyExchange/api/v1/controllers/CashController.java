package sin2cos2.currencyExchange.api.v1.controllers;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import sin2cos2.currencyExchange.api.v1.model.CashDTO;
import sin2cos2.currencyExchange.services.CashService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/cash")
public class CashController {

    private final CashService cashService;

    @Operation(summary = "Add or update the amount of money in the cash desk")
    @PutMapping()
    public Mono<CashDTO> updateCashInCashDesk(@RequestBody CashDTO cashDTO) {
        return cashService.updateCash(cashDTO);
    }
}
