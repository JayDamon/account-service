UPDATE account SET current_balance = 0 WHERE current_balance IS NULL;

ALTER TABLE account MODIFY current_balance decimal NOT NULL;

