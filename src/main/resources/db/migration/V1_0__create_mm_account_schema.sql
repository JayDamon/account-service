CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE IF NOT EXISTS account_type
(
    account_type_id    uuid DEFAULT uuid_generate_v4() not null,
    full_account_type  varchar(255),
    short_account_type varchar(255),
    PRIMARY KEY (account_type_id)
);


CREATE TABLE IF NOT EXISTS account
(
    account_id         uuid DEFAULT uuid_generate_v4() not null,
    name               varchar(255),
    starting_balance   decimal,
    current_balance    decimal NOT NULL,
    is_primary_account boolean,
    is_in_cash_flow    boolean,
    account_type_id    uuid,
    tenant_id          varchar(255),
    PRIMARY KEY (account_id),
    FOREIGN KEY (account_type_id) REFERENCES account_type (account_type_id)
);

INSERT INTO account_type(account_type_id,full_account_type,short_account_type)
VALUES
       ('09a3b555-ea95-4f5b-a4e5-660d5f3657e5', 'Basic Checking', 'Checking'),
       ('e20209f2-9ec6-40f8-9478-ac0e5dd91c7b', 'Savings', 'Savings'),
       ('105e53a4-a1cd-4b2e-97fc-82faae39d355', 'Interest Bearing Checking', 'Interest'),
       ('e7544f6b-f58a-45c6-9675-8a4eb06815ab', 'Money Market', 'MM'),
       ('3b858d4b-912c-4821-9933-2bae982a1644', 'Certification of Deposit', 'CD'),
       ('690048ab-ee21-4abf-b328-37cb9be92a20', 'Investment Retirement', 'Retirement'),
       ('242f768e-337c-4398-a845-6ea24b6e82dd', 'Brokerage', 'Brokerage'),
       ('2ecb00fd-1163-4a0d-885b-2b45d851bdde', 'Credit Card', 'Credit Card');

