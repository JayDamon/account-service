package com.factotum.setzer.mapper;

import com.factotum.setzer.model.Account;
import com.factotum.setzer.model.AccountType;
import io.r2dbc.spi.Row;
import org.springframework.boot.autoconfigure.batch.BatchProperties;

import java.math.BigDecimal;
import java.util.function.BiFunction;

public class AccountMapper implements BiFunction<Row, Object, Account> {
    @Override
    public Account apply(Row row, Object o) {
        AccountType accountType = new AccountType();
        accountType.setId(row.get("account_type_id", Integer.class));
        accountType.setFullName(row.get("full_account_type", String.class));
        accountType.setShortName(row.get("short_account_type", String.class));

        Account account = new Account();
        account.setId(row.get("id", Long.class));
        account.setName(row.get("name", String.class));
        account.setAccountType(accountType);
        account.setAccountTypeId(accountType.getId());
        account.setStartingBalance(row.get("starting_balance", BigDecimal.class));
        account.setCurrentBalance(row.get("current_balance", BigDecimal.class));
        account.setIsPrimaryAccount(row.get("is_primary_account", Boolean.class));
        account.setIsInCashFlow(row.get("is_in_cash_flow", Boolean.class));

        return account;
    }
}
