package sin2cos2.currencyExchange.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import sin2cos2.currencyExchange.model.CurrencyRateDTO;
import sin2cos2.currencyExchange.services.CurrencyRateService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/currencyRate")
public class CurrencyRateController {

    private final CurrencyRateService currencyRateService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<CurrencyRateDTO> createNewCurrencyRate(@RequestBody CurrencyRateDTO currencyRateDTO) {
        return currencyRateService.save(currencyRateDTO);
    }

    @GetMapping("/{currencyAbbreviation}")
    public Flux<CurrencyRateDTO> getCurrencyRateByCurrency(@PathVariable String currencyAbbreviation) {
        return currencyRateService.getCurrencyRateByCurrency(currencyAbbreviation);
    }
}
