package com.factotum.accountservice.mapper;

import com.factotum.accountservice.dto.AccountDto;
import io.r2dbc.spi.Row;

import java.math.BigDecimal;
import java.util.UUID;
import java.util.function.BiFunction;

public class AccountMapper implements BiFunction<Row, Object, AccountDto> {
    @Override
    public AccountDto apply(Row row, Object o) {

        System.out.println(row);

        AccountDto account = new AccountDto();
        account.setId(row.get("account_id", UUID.class));
        account.setFriendlyName(row.get("friendly_name", String.class));
        account.setName(row.get("name", String.class));
        account.setMask(row.get("mask", String.class));
        account.setAvailableBalance(row.get("available_balance", BigDecimal.class));
        account.setStartingBalance(row.get("starting_balance", BigDecimal.class));
        account.setCurrentBalance(row.get("current_balance", BigDecimal.class));
        account.setLimit(row.get("account_limit", BigDecimal.class));
        account.setIsPrimaryAccount(row.get("is_primary_account", Boolean.class));
        account.setIsInCashFlow(row.get("is_in_cash_flow", Boolean.class));
        account.setAccountTypeName(row.get("account_type", String.class));
        account.setAccountSubTypeName(row.get("account_sub_type", String.class));

        return account;
    }
}
