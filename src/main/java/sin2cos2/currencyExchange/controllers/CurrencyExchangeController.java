package sin2cos2.currencyExchange.controllers;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import sin2cos2.currencyExchange.model.CurrencyExchangeDTO;
import sin2cos2.currencyExchange.services.CurrencyExchangeService;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/currencyExchanges")
public class CurrencyExchangeController {

    private final CurrencyExchangeService currencyExchangeService;

    @Operation(summary = "Save a new transaction")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Mono<CurrencyExchangeDTO> saveNewTransaction(@RequestBody CurrencyExchangeDTO currencyExchangeDTO) {
        return currencyExchangeService.saveNewTransaction(currencyExchangeDTO);
    }
}
