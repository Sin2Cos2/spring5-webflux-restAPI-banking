# Description
This project is a simple REST API service aimed at learning and using the WebFlux technology.
---

## Functionality

### GET requests

- Get list of currency rates for today by currency abbreviation
    > /api/v1/currencyRates/{currencyAbbreviation}

### POST requests

- Add new currency rate
    > /api/v1/currencyRates
    #### Request body:
    
        Long ration;
        BigDecimal rate;
        String currency;
        LocalDate date;

- Save a new transaction
    > /api/v1/currencyExchanges
    #### Request body:
  
        BigDecimal receivedAmount;
        String receivedCurrency;
        BigDecimal releasedAmount;
        String releasedCurrency;
        BigDecimal rate;
        String staff;
        Long cashDeskId;
        LocalDateTime date;

### PUT requests

- Add or update the amount of money in the cash desk
    > /api/v1/cash
    #### Request body:

        String currency;
        Long cashDeskId;
        BigDecimal cash;    
        LocalDateTime date;