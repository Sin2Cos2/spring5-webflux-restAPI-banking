INSERT INTO staff(name) VALUE('employee1');
INSERT INTO staff(name) VALUE('employee2');

INSERT INTO currency_dictionary(abbreviation, currency) VALUES ('EUR', 'Euro');
INSERT INTO currency_dictionary(abbreviation, currency) VALUES ('MDL', 'Moldovan leu');
INSERT INTO currency_dictionary(abbreviation, currency) VALUES ('USD', 'American dollar');

INSERT INTO currency_rate(ratio, rate, currency, date) VALUES (1, '19.53', 'EUR', now());
INSERT INTO currency_rate(ratio, rate, currency, date) VALUES (1, '19.13', 'USD', now());

INSERT INTO cash_desk() VALUE ();
INSERT INTO cash_desk() VALUE ();

INSERT INTO cash(currency, cash_desk_id, cash, date) VALUES ('MDL', 1, 5000, now());
INSERT INTO cash(currency, cash_desk_id, cash, date) VALUES ('EUR', 1, 200, now());
INSERT INTO cash(currency, cash_desk_id, cash, date) VALUES ('MDL', 2, 5000, now());
INSERT INTO cash(currency, cash_desk_id, cash, date) VALUES ('USD', 2, 200, now());
