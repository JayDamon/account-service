INSERT INTO account(account_id, friendly_name, name, official_name, starting_balance, available_balance, current_balance, account_limit, is_primary_account, is_in_cash_flow, account_type, account_sub_type, tenant_id)
VALUES
       ('43b38f84-ed18-4801-803f-2f4be3119d3f', 'Friendly Checking', 'My Checking','My Checking Official',500.01,8000.56,8000.56, null,TRUE,TRUE,'depository','checking','5809b48e-b705-4b3e-be9f-16ce0380cb45'),
       ('b6b59a87-a54b-40a4-bb67-c5eb90c96a35', 'Friendly Savings', 'My Savings','My Savings Official',100.34,7000.21,7000.21,null,FALSE,TRUE,'depository','savings','5809b48e-b705-4b3e-be9f-16ce0380cb45'),
       ('ddf60fa8-24c8-4cd1-8cf2-3572844f74b3', 'Friendly Money Market', 'My Money Market','My Money Market Official', 50,6000,6000,null,FALSE,TRUE,'depository','money market','5809b48e-b705-4b3e-be9f-16ce0380cb45'),
       ('fe961970-6a7d-4d6e-9103-627c141ce4e3', 'Friendly Visa', 'My Visa','My Visa Official',0,50.45,50.45,10000,FALSE,TRUE,'credit','credit card','5809b48e-b705-4b3e-be9f-16ce0380cb45'),
       ('318009cd-49d5-4e9d-bbdb-432b1da92ae6', 'Friendly Master Card', 'My Master Card','My Master Card Official',0,2000.32,2000.32,20000,FALSE,TRUE,'credit','credit card','5809b48e-b705-4b3e-be9f-16ce0380cb45'),
       ('3a8a7955-b6aa-463f-8336-12515aef4b16', 'Friendly Retirement', 'My Retirement','My Retirement Official',0,1540,1540,null,FALSE,FALSE,'investment','401k','5809b48e-b705-4b3e-be9f-16ce0380cb45'),
       ('cb092f82-8c71-47b1-8e5a-77929b8db57a','Friendly tenant 2 checking', 'Tenant 2 checking','Tenant 2 checking Official',500.01,8000.56,8000.56,null,TRUE,TRUE,'depository','checking','7c21bdec-219e-4492-a2fd-e6a2ec5fb8fa');
