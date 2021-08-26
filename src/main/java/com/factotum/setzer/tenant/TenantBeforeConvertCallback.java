package com.factotum.setzer.tenant;

import com.factotum.setzer.model.Account;
import lombok.extern.slf4j.Slf4j;
import org.reactivestreams.Publisher;
import org.springframework.data.r2dbc.mapping.event.BeforeConvertCallback;
import org.springframework.data.relational.core.sql.SqlIdentifier;
import org.springframework.lang.NonNull;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.ReactiveSecurityContextHolder;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Slf4j
@Component
public class TenantBeforeConvertCallback implements BeforeConvertCallback<Account> {

    @Override
    @NonNull
    public Publisher<Account> onBeforeConvert(@NonNull Account entity, @NonNull SqlIdentifier table) {

        if (entity.getTenantId() != null) return Mono.just(entity);

        return ReactiveSecurityContextHolder.getContext()
                .map(SecurityContext::getAuthentication)
                .map(Authentication::getPrincipal)
                .cast(Jwt.class)
                .flatMap(jwt -> {
                    String tenantId = (String) jwt.getClaims().get("sub");
                    if (entity.getTenantId() != null && !entity.getTenantId().equals(tenantId)) {
                        return Mono.empty();
                    }
                    entity.setTenantId(tenantId);
                    return Mono.just(entity);
                })
                .doOnError(t -> log.error("Failed to set Tenant Id", t));
    }
}