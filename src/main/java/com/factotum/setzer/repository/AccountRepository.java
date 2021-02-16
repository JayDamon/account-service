package com.factotum.setzer.repository;

import com.factotum.setzer.model.Account;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends ReactiveCrudRepository<Account, Long>, AccountRepositoryCustom {
}
