package com.factotum.setzer.repository;

import com.factotum.setzer.model.Account;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface AccountRepository extends ReactiveCrudRepository<Account, Long>, AccountRepositoryCustom {

    Mono<Account> queryByIdAndTenantId(long id, String tenantId);

}
