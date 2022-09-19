package sin2cos2.currencyExchange.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;
import reactor.core.publisher.Mono;
import sin2cos2.currencyExchange.domain.Cash;
import sin2cos2.currencyExchange.domain.CurrencyExchange;
import sin2cos2.currencyExchange.domain.Staff;
import sin2cos2.currencyExchange.model.CurrencyExchangeDTO;
import sin2cos2.currencyExchange.repositories.CashRepository;
import sin2cos2.currencyExchange.repositories.CurrencyExchangeRepository;
import sin2cos2.currencyExchange.repositories.StaffRepository;
import sin2cos2.currencyExchange.services.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class CurrencyExchangeControllerTest {

    WebTestClient webTestClient;

    StaffRepository staffRepository;
    StaffService staffService;

    CashRepository cashRepository;
    CashService cashService;

    CurrencyExchangeRepository currencyExchangeRepository;
    CurrencyExchangeService currencyExchangeService;
    CurrencyExchangeController currencyExchangeController;

    CurrencyExchangeDTO currencyExchangeToSave;
    CurrencyExchange currencyExchange;
    Staff staff;
    Cash testCash;

    @BeforeEach
    void setUp() {
        staffRepository = Mockito.mock(StaffRepository.class);
        staffService = new StaffServiceImpl(staffRepository);

        cashRepository = Mockito.mock(CashRepository.class);
        cashService = new CashServiceImpl(cashRepository);

        currencyExchangeRepository = Mockito.mock(CurrencyExchangeRepository.class);
        currencyExchangeService = new CurrencyExchangeServiceImpl(currencyExchangeRepository,
                staffService, cashService);

        currencyExchangeController = new CurrencyExchangeController(currencyExchangeService);
        webTestClient = WebTestClient.bindToController(currencyExchangeController).build();

        currencyExchangeToSave = CurrencyExchangeDTO.builder()
                .receivedCurrency("MDL")
                .receivedAmount(new BigDecimal("400"))
                .releasedCurrency("EUR")
                .releasedAmount(new BigDecimal("20"))
                .rate(new BigDecimal("20"))
                .staff("employee1")
                .cashDeskId(1L)
                .build();

        currencyExchange = CurrencyExchange.builder()
                .receivedCurrency("MDL")
                .receivedAmount(new BigDecimal("400"))
                .releasedCurrency("EUR")
                .releasedAmount(new BigDecimal("20"))
                .rate(new BigDecimal("20"))
                .staffId(1L)
                .cashDeskId(1L)
                .build();

        staff = Staff.builder().name("employee1").id(1L).build();

        testCash = Cash.builder().cash(new BigDecimal("500"))
                .id(1L)
                .currency("GEN")
                .cashDeskId(1L)
                .date(LocalDateTime.now())
                .build();
    }

    @Test
    void saveNewTransaction() {
        Mockito.when(staffRepository.findByName(any()))
                .thenReturn(Mono.just(staff));

        Mockito.when(cashRepository.findByCashDeskIdAndCurrency(any(), any()))
                .thenReturn(Mono.just(testCash));

        when(cashRepository.save(any())).thenReturn(Mono.just(testCash));

        when(currencyExchangeRepository.save(any())).thenReturn(Mono.just(currencyExchange));

        webTestClient.post()
                .uri("/currencyExchanges")
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(currencyExchangeToSave))
                .exchange()
                .expectStatus()
                .isCreated()
                .expectBody(CurrencyExchangeDTO.class);
    }

    @Test
    void saveNewTransactionNoMDL() {

        currencyExchangeToSave.setReceivedCurrency("USD");

        Mockito.when(staffRepository.findByName(any()))
                .thenReturn(Mono.just(staff));

        Mockito.when(cashRepository.findByCashDeskIdAndCurrency(any(), any()))
                .thenReturn(Mono.just(testCash));

        when(cashRepository.save(any())).thenReturn(Mono.just(testCash));

        when(currencyExchangeRepository.save(any())).thenReturn(Mono.just(currencyExchange));

        webTestClient.post()
                .uri("/currencyExchanges")
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(currencyExchangeToSave))
                .exchange()
                .expectStatus()
                .is5xxServerError();
    }

    @Test
    void saveNewTransactionCashNotFound() {

        Mockito.when(staffRepository.findByName(any()))
                .thenReturn(Mono.just(staff));

        Mockito.when(cashRepository.findByCashDeskIdAndCurrency(any(), any()))
                .thenReturn(Mono.empty());

        when(cashRepository.save(any())).thenReturn(Mono.just(testCash));

        when(currencyExchangeRepository.save(any())).thenReturn(Mono.just(currencyExchange));

        webTestClient.post()
                .uri("/currencyExchanges")
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(currencyExchangeToSave))
                .exchange();

        verify(cashRepository, times(0)).save(any());
        verify(currencyExchangeRepository, times(0)).save(any());
    }

    @Test
    void saveNewTransactionNotEnoughMoney() {

        currencyExchangeToSave.setReleasedAmount(new BigDecimal("1000"));

        Mockito.when(staffRepository.findByName(any()))
                .thenReturn(Mono.just(staff));

        Mockito.when(cashRepository.findByCashDeskIdAndCurrency(any(), any()))
                .thenReturn(Mono.just(testCash));

        when(cashRepository.save(any())).thenReturn(Mono.just(testCash));

        when(currencyExchangeRepository.save(any())).thenReturn(Mono.just(currencyExchange));

        webTestClient.post()
                .uri("/currencyExchanges")
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(currencyExchangeToSave))
                .exchange();

        verify(cashRepository, times(0)).save(any());
        verify(currencyExchangeRepository, times(0)).save(any());
    }
}