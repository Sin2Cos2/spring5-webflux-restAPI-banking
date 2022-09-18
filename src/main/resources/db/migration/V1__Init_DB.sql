CREATE TABLE `currency_dictionary`
(
    `abbreviation` varchar(3) NOT NULL PRIMARY KEY,
    `currency`     varchar(255)
);

CREATE TABLE `staff`
(
    `id`   int8 NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `name` varchar(255)
);

CREATE TABLE `cash`
(
    `id`           int8 NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `currency`     varchar(3),
    `cash_desk_id` int8,
    `cash`         decimal(15, 2),
    `date`         datetime
);

CREATE TABLE `cash_desk`
(
    `id` int8 NOT NULL PRIMARY KEY AUTO_INCREMENT
);

CREATE TABLE `currency_rate`
(
    `id`       int8 NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `ratio`    int8,
    `rate`     decimal(15, 2),
    `currency` varchar(3),
    `date`     date
);

CREATE TABLE `currency_exchange`
(
    `id`                int8 NOT NULL PRIMARY KEY AUTO_INCREMENT,
    `received_amount`   decimal(15, 2),
    `received_currency` varchar(3),
    `released_amount`   decimal(15, 2),
    `released_currency` varchar(3),
    `rate`              decimal(15, 2),
    `staff_id`          int8,
    `cash_desk_id`      int8,
    `date`              datetime
);

ALTER TABLE `cash`
    ADD FOREIGN KEY (`currency`) REFERENCES `currency_dictionary` (`abbreviation`);

ALTER TABLE `cash`
    ADD FOREIGN KEY (`cash_desk_id`) REFERENCES `cash_desk` (`id`);

ALTER TABLE `currency_rate`
    ADD FOREIGN KEY (`currency`) REFERENCES `currency_dictionary` (`abbreviation`);

ALTER TABLE `currency_exchange`
    ADD FOREIGN KEY (`received_currency`) REFERENCES `currency_dictionary` (`abbreviation`);

ALTER TABLE `currency_exchange`
    ADD FOREIGN KEY (`released_currency`) REFERENCES `currency_dictionary` (`abbreviation`);

ALTER TABLE `currency_exchange`
    ADD FOREIGN KEY (`staff_id`) REFERENCES `staff` (`id`);

ALTER TABLE `currency_exchange`
    ADD FOREIGN KEY (`cash_desk_id`) REFERENCES `cash_desk` (`id`);
