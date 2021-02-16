package com.factotum.setzer.repository;

import com.factotum.setzer.dto.AccountDto;
import reactor.core.publisher.Flux;

public interface AccountRepositoryCustom {

    Flux<AccountDto> queryAll();

}
