package com.factotum.setzer.repository;

import com.factotum.setzer.dto.AccountDto;
import com.factotum.setzer.mapper.AccountMapper;
import org.springframework.r2dbc.core.DatabaseClient;
import reactor.core.publisher.Flux;

public class AccountRepositoryCustomImpl implements AccountRepositoryCustom {

    private final DatabaseClient databaseClient;

    public AccountRepositoryCustomImpl(DatabaseClient databaseClient) {
        this.databaseClient = databaseClient;
    }

    private static final String SELECT_QUERY = "SELECT a.id, a.name, at.id as account_type_id, " +
            "at.full_account_type, at.short_account_type, " +
            "a.starting_balance, a.current_balance, a.is_primary_account, a.is_in_cash_flow " +
            "FROM account a " +
            "LEFT JOIN account_type at ON at.id = a.account_type_id";

    @Override
    public Flux<AccountDto> queryAll() {

        return this.databaseClient.sql(SELECT_QUERY).map(new AccountMapper()::apply).all();
    }
}
