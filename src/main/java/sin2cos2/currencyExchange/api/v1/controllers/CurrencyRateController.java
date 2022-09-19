package sin2cos2.currencyExchange.api.v1.controllers;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import sin2cos2.currencyExchange.api.v1.model.CurrencyRateDTO;
import sin2cos2.currencyExchange.services.CurrencyRateService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/currencyRates")
public class CurrencyRateController {

    private final CurrencyRateService currencyRateService;

    @Operation(summary = "Add new currency rate")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<CurrencyRateDTO> createNewCurrencyRate(@RequestBody CurrencyRateDTO currencyRateDTO) {
        return currencyRateService.save(currencyRateDTO);
    }

    @Operation(summary = "Get list of currency rates for today by currency abbreviation")
    @GetMapping("/{currencyAbbreviation}")
    public Flux<CurrencyRateDTO> getCurrencyRateByCurrency(@PathVariable String currencyAbbreviation) {
        return currencyRateService.getCurrencyRateByCurrency(currencyAbbreviation);
    }
}
