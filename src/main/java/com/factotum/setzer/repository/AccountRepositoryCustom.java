package com.factotum.setzer.repository;

import com.factotum.setzer.model.Account;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface AccountRepositoryCustom {

    Mono<Account> findById(long id);

    Flux<Account> findAll();

}
