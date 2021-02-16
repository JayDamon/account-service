package com.factotum.setzer.service;

import com.factotum.setzer.model.Account;
import reactor.core.publisher.Mono;

public interface AccountService {

    Mono<Account> save(Account account);

}
