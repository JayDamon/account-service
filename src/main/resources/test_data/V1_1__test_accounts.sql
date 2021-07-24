INSERT INTO account (account_id, name, account_type_id, starting_balance, current_balance, is_primary_account, is_in_cash_flow)
VALUES (1, 'My Checking', 1, 500.01, 8000.56, 1, 1),
       (2, 'My Savings', 2, 100.34, 7000.21, 0, 1),
       (3, 'My Money Market', 4, 50, 6000, 0, 1),
       (4, 'My Visa', 8, 0, 50.45, 0, 1),
       (5, 'My Master Card', 8, 0, 2000.32, 0, 1),
       (6, 'My Retirement', 6, 0, 1540, 0, 0);
