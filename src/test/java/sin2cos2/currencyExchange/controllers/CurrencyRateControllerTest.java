package sin2cos2.currencyExchange.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import sin2cos2.currencyExchange.domain.CurrencyRate;
import sin2cos2.currencyExchange.model.CurrencyRateDTO;
import sin2cos2.currencyExchange.repositories.CurrencyRateRepository;
import sin2cos2.currencyExchange.services.CurrencyRateService;
import sin2cos2.currencyExchange.services.CurrencyRateServiceImpl;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

class CurrencyRateControllerTest {

    WebTestClient webTestClient;
    CurrencyRateRepository currencyRateRepository;
    CurrencyRateService currencyRateService;
    CurrencyRateController currencyRateController;

    @BeforeEach
    void setUp() {
        currencyRateRepository = Mockito.mock(CurrencyRateRepository.class);
        currencyRateService = new CurrencyRateServiceImpl(currencyRateRepository);
        currencyRateController = new CurrencyRateController(currencyRateService);
        webTestClient = WebTestClient.bindToController(currencyRateController).build();
    }

    @Test
    void createNewCurrencyRate() {
        CurrencyRate currencyRate = CurrencyRate.builder()
                .rate(new BigDecimal("21.3"))
                .currency("GBP")
                .ratio(1L)
                .date(LocalDate.now())
                .build();

        given(currencyRateRepository.save(any()))
                .willReturn(Mono.just(currencyRate));

        CurrencyRateDTO currencyRateToSave = new CurrencyRateDTO();
        currencyRateToSave.setCurrency("BGP");

        webTestClient.post()
                .uri("/currencyRates")
                .body(Mono.just(currencyRateToSave), CurrencyRateDTO.class)
                .exchange()
                .expectStatus()
                .isCreated();
    }

    @Test
    void getCurrencyRateByCurrency() {
        CurrencyRate currencyRate = CurrencyRate.builder()
                .rate(new BigDecimal("21.3"))
                .currency("GBP")
                .ratio(1L)
                .date(LocalDate.now())
                .build();

        given(currencyRateRepository.findByCurrencyAndDate(any(), any()))
                .willReturn(Flux.just(currencyRate));

        webTestClient.get()
                .uri("/currencyRates/GBP")
                .exchange()
                .expectBodyList(CurrencyRateDTO.class);
    }
}