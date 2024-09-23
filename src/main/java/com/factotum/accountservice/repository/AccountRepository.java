package com.factotum.accountservice.repository;

import com.factotum.accountservice.model.Account;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Repository
public interface AccountRepository extends ReactiveCrudRepository<Account, UUID>, AccountRepositoryCustom {

    Mono<Account> queryByIdAndTenantId(UUID id, String tenantId);

    Mono<Account> queryByPlaidIdAndTenantId(String plaidId, String tenantId);

}
