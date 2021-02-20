DROP TABLE IF EXISTS account;
DROP TABLE IF EXISTS account_type;

CREATE TABLE account_type
(
    id                 int NOT NULL AUTO_INCREMENT,
    full_account_type  varchar(255),
    short_account_type varchar(255),
    PRIMARY KEY (id)
);


CREATE TABLE account
(
     id long NOT NULL AUTO_INCREMENT,
     name varchar(255),
     starting_balance decimal,
     current_balance decimal,
     is_primary_account bit,
     is_in_cash_flow bit,
     account_type_id int,
     PRIMARY KEY (id),
     FOREIGN KEY (account_type_id) REFERENCES account_type(id)
);
