package com.factotum.setzer.repository;

import com.factotum.setzer.dto.AccountDto;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import reactor.core.publisher.Flux;

public interface AccountRepositoryCustom {

    Flux<AccountDto> queryAll(Jwt jwt);

}
