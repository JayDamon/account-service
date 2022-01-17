package com.factotum.accountservice.repository;

import com.factotum.accountservice.model.AccountType;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountTypeRepository extends ReactiveCrudRepository<AccountType, Integer> {
}
