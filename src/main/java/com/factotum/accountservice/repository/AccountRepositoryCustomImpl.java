package com.factotum.accountservice.repository;

import com.factotum.accountservice.dto.AccountDto;
import com.factotum.accountservice.mapper.AccountMapper;
import org.springframework.r2dbc.core.DatabaseClient;
import org.springframework.security.oauth2.jwt.Jwt;
import reactor.core.publisher.Flux;

public class AccountRepositoryCustomImpl implements AccountRepositoryCustom {

    private final DatabaseClient databaseClient;

    public AccountRepositoryCustomImpl(DatabaseClient databaseClient) {
        this.databaseClient = databaseClient;
    }

    private static final String SELECT_QUERY = """
            SELECT a.account_id, a.friendly_name, a.name, a.mask,
            a.starting_balance, a.current_balance, a.is_primary_account, a.is_in_cash_flow,
            a.available_balance, a.account_limit, a.account_type, a.account_sub_type
            FROM account a
            WHERE a.tenant_id = :tenantId""";

    @Override
    public Flux<AccountDto> queryAll(Jwt jwt) {
        return this.databaseClient.sql(SELECT_QUERY).bind("tenantId", jwt.getClaimAsString("sub")).map(new AccountMapper()::apply).all();
    }
}
