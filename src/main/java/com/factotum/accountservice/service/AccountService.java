package com.factotum.accountservice.service;

import com.factotum.accountservice.dto.AccountDto;
import com.factotum.accountservice.model.Account;
import reactor.core.publisher.Mono;

public interface AccountService {

    Mono<Account> update(AccountDto account);

}
