package com.factotum.accountservice.repository;

import com.factotum.accountservice.dto.AccountDto;
import org.springframework.security.oauth2.jwt.Jwt;
import reactor.core.publisher.Flux;

public interface AccountRepositoryCustom {

    Flux<AccountDto> queryAll(Jwt jwt);

}
