package com.factotum.setzer.service;

import com.factotum.setzer.dto.AccountDto;
import com.factotum.setzer.model.Account;
import reactor.core.publisher.Mono;

public interface AccountService {

    Mono<Account> update(AccountDto account);

}
