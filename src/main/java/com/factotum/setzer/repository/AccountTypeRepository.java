package com.factotum.setzer.repository;

import com.factotum.setzer.model.Account;
import com.factotum.setzer.model.AccountType;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountTypeRepository extends ReactiveCrudRepository<AccountType, Long> {
}
