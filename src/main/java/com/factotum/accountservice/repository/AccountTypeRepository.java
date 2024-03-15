package com.factotum.accountservice.repository;

import com.factotum.accountservice.model.AccountType;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AccountTypeRepository extends ReactiveCrudRepository<AccountType, UUID> {
}
