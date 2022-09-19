package sin2cos2.currencyExchange.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import sin2cos2.currencyExchange.model.CurrencyExchangeDTO;
import sin2cos2.currencyExchange.services.CurrencyExchangeService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/currencyExchange")
public class CurrencyExchangeController {

    private final CurrencyExchangeService currencyExchangeService;

    @PostMapping
    public Mono<CurrencyExchangeDTO> saveNewTransaction(@RequestBody CurrencyExchangeDTO currencyExchangeDTO) {
        return currencyExchangeService.saveNewTransaction(currencyExchangeDTO);
    }
}