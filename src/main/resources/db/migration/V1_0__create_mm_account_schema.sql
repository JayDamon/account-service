CREATE TABLE IF NOT EXISTS account_type
(
    account_type_id    INT NOT NULL AUTO_INCREMENT,
    full_account_type  varchar(255),
    short_account_type varchar(255),
    PRIMARY KEY (account_type_id)
);


CREATE TABLE IF NOT EXISTS account
(
    account_id         BIGINT NOT NULL AUTO_INCREMENT,
    name               varchar(255),
    starting_balance   decimal,
    current_balance    decimal,
    is_primary_account bit,
    is_in_cash_flow    bit,
    account_type_id    int,
    PRIMARY KEY (account_id),
    FOREIGN KEY (account_type_id) REFERENCES account_type (account_type_id)
);

INSERT INTO account_type (account_type_id, full_account_type, short_account_type)
VALUES (1, 'Basic Checking', 'Checking'),
       (2, 'Savings', 'Savings'),
       (3, 'Interest Bearing Checking', 'Interest'),
       (4, 'Money Market', 'MM'),
       (5, 'Certification of Deposit', 'CD'),
       (6, 'Investment Retirement', 'Retirement'),
       (7, 'Brokerage', 'Brokerage'),
       (8, 'Credit Card', 'Credit Card');
