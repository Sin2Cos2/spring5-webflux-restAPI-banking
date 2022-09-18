CREATE TABLE `currency_dictionary`
(
    `id`           int8 AUTO_INCREMENT NOT NULL PRIMARY KEY,
    `abbreviation` varchar(255),
    `currency`     varchar(255)
);

CREATE TABLE `staff`
(
    `id`   int8 NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `name` varchar(255)
);

CREATE TABLE `cash`
(
    `id`                     int8 NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `currency_dictionary_id` int8,
    `cash_desk_id`           int8,
    `cash`                   decimal(15,2),
    `date`                   datetime
);

CREATE TABLE `cash_desk`
(
    `id` int8 NOT NULL PRIMARY KEY AUTO_INCREMENT
);

CREATE TABLE `currency_rate`
(
    `id`                     int8 NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `ratio`                  int8,
    `rate`                   decimal(15,2),
    `currency_dictionary_id` int8,
    `date`                   date
);

CREATE TABLE `currency_exchange`
(
    `id`                   int8 NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `received_amount`      decimal(15,2),
    `received_currency_id` int8,
    `released_amount`      decimal(15,2),
    `released_currency_id` int8,
    `rate`                 decimal(15,2),
    `staff_id`             int8,
    `cash_desk_id`         int8,
    `date`                 datetime
);

ALTER TABLE `cash`
    ADD FOREIGN KEY (`currency_dictionary_id`) REFERENCES `currency_dictionary` (`id`);

ALTER TABLE `cash`
    ADD FOREIGN KEY (`cash_desk_id`) REFERENCES `cash_desk` (`id`);

ALTER TABLE `currency_rate`
    ADD FOREIGN KEY (`currency_dictionary_id`) REFERENCES `currency_dictionary` (`id`);

ALTER TABLE `currency_exchange`
    ADD FOREIGN KEY (`received_currency_id`) REFERENCES `currency_dictionary` (`id`);

ALTER TABLE `currency_exchange`
    ADD FOREIGN KEY (`released_currency_id`) REFERENCES `currency_dictionary` (`id`);

ALTER TABLE `currency_exchange`
    ADD FOREIGN KEY (`staff_id`) REFERENCES `staff` (`id`);

ALTER TABLE `currency_exchange`
    ADD FOREIGN KEY (`cash_desk_id`) REFERENCES `cash_desk` (`id`);
