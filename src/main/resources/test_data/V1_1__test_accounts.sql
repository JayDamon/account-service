INSERT INTO account(account_id, name, account_type_id, starting_balance, current_balance, is_primary_account, is_in_cash_flow,tenant_id)
VALUES
       ('43b38f84-ed18-4801-803f-2f4be3119d3f', 'My Checking','09a3b555-ea95-4f5b-a4e5-660d5f3657e5',500.01,8000.56,TRUE,TRUE,'5809b48e-b705-4b3e-be9f-16ce0380cb45'),
       ('b6b59a87-a54b-40a4-bb67-c5eb90c96a35', 'My Savings','e20209f2-9ec6-40f8-9478-ac0e5dd91c7b',100.34,7000.21,FALSE,TRUE,'5809b48e-b705-4b3e-be9f-16ce0380cb45'),
       ('ddf60fa8-24c8-4cd1-8cf2-3572844f74b3', 'My Money Market','e7544f6b-f58a-45c6-9675-8a4eb06815ab',50,6000,FALSE,TRUE,'5809b48e-b705-4b3e-be9f-16ce0380cb45'),
       ('fe961970-6a7d-4d6e-9103-627c141ce4e3', 'My Visa','2ecb00fd-1163-4a0d-885b-2b45d851bdde',0,50.45,FALSE,TRUE,'5809b48e-b705-4b3e-be9f-16ce0380cb45'),
       ('318009cd-49d5-4e9d-bbdb-432b1da92ae6', 'My Master Card','2ecb00fd-1163-4a0d-885b-2b45d851bdde',0,2000.32,FALSE,TRUE,'5809b48e-b705-4b3e-be9f-16ce0380cb45'),
       ('3a8a7955-b6aa-463f-8336-12515aef4b16', 'My Retirement','690048ab-ee21-4abf-b328-37cb9be92a20',0,1540,FALSE,FALSE,'5809b48e-b705-4b3e-be9f-16ce0380cb45'),
       ('cb092f82-8c71-47b1-8e5a-77929b8db57a','Tenant 2 checking','09a3b555-ea95-4f5b-a4e5-660d5f3657e5',500.01,8000.56,TRUE,TRUE,'7c21bdec-219e-4492-a2fd-e6a2ec5fb8fa');
