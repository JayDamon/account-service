package com.factotum.accountservice.controller;

import com.factotum.accountservice.dto.AccountDto;
import com.factotum.accountservice.model.Account;
import com.factotum.accountservice.repository.AccountRepository;
import com.factotum.accountservice.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import jakarta.validation.Valid;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping(value = "/v1/accounts")
public class AccountController {

    private final AccountRepository accountRepository;
    private final AccountService accountService;

    public AccountController(AccountRepository accountRepository, AccountService accountService) {
        this.accountRepository = accountRepository;
        this.accountService = accountService;
    }

    @GetMapping("")
    Flux<AccountDto> getAccounts(JwtAuthenticationToken jwt) {
        return this.accountRepository.queryAll(jwt.getToken());
    }

    @GetMapping("/{id}")
    Mono<AccountDto> getAccountById(JwtAuthenticationToken jwt, @PathVariable(name = "id") UUID id) {
        return this.accountRepository
                .queryByIdAndTenantId(id, jwt.getToken().getClaimAsString("sub"))
                .map(a -> new ModelMapper().map(a, AccountDto.class));
    }

    @PostMapping("")
    Mono<AccountDto> create(@Valid @RequestBody AccountDto newAccount) {
        Account account = new ModelMapper().map(newAccount, Account.class);
        account.setCurrentBalance(newAccount.getStartingBalance());
        return this.accountRepository.save(account).map(a -> new ModelMapper().map(a, AccountDto.class));
    }

    @PatchMapping("/{id}")
    Mono<AccountDto> updateAccount(@PathVariable UUID id, @RequestBody AccountDto account) {

        if (account.getId() == null) {
            throw new IllegalArgumentException("Valid account id must be provided");
        }

        if (!id.equals(account.getId())) {
            throw new IllegalArgumentException("Path id and body id must match");
        }

        return accountService.update(account).map(a -> new ModelMapper().map(a, AccountDto.class));
    }

}
