package sin2cos2.currencyExchange.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;
import sin2cos2.currencyExchange.api.v1.controllers.CashController;
import sin2cos2.currencyExchange.domain.Cash;
import sin2cos2.currencyExchange.repositories.CashRepository;
import sin2cos2.currencyExchange.services.CashService;
import sin2cos2.currencyExchange.services.CashServiceImpl;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.mockito.BDDMockito.given;

class CashControllerTest {

    WebTestClient webTestClient;
    CashRepository cashRepository;
    CashService cashService;
    CashController cashController;


    @BeforeEach
    void setUp() {
        cashRepository = Mockito.mock(CashRepository.class);
        cashService = new CashServiceImpl(cashRepository);
        cashController = new CashController(cashService);
        webTestClient = WebTestClient.bindToController(cashController).build();
    }

    @Test
    void updateExistedCashInCashDesk() {
        Cash cash = Cash.builder()
                .currency("MDL")
                .cash(new BigDecimal(10000))
                .cashDeskId(1L)
                .date(LocalDateTime.now())
                .build();

        given(cashRepository.findByCashDeskIdAndCurrency(0L, "someCurrency"))
                .willReturn(Mono.just(cash));

        webTestClient.get()
                .uri("/api/v1/cash")
                .exchange()
                .expectBody(Cash.class);
    }

    @Test
    void saveNewCashInCashDesk() {
        Cash cash = Cash.builder()
                .currency("USD")
                .cash(new BigDecimal(10000))
                .cashDeskId(1L)
                .date(LocalDateTime.now())
                .build();

        given(cashRepository.findByCashDeskIdAndCurrency(0L, "someCurrency"))
                .willReturn(Mono.just(cash));

        webTestClient.get()
                .uri("/api/v1/cash")
                .exchange()
                .expectBody(Cash.class);
    }
}