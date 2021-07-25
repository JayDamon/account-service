package com.factotum.setzer.controller;

import com.factotum.setzer.dto.AccountDto;
import com.factotum.setzer.model.Account;
import com.factotum.setzer.repository.AccountRepository;
import com.factotum.setzer.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

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
    Flux<AccountDto> getAccounts() {
        return this.accountRepository.queryAll();
    }

    @GetMapping("/{id}")
    Mono<AccountDto> getAccountById(@PathVariable(name = "id") long id) {
        log.info("Retrieving account {}", id);
        return this.accountRepository.findById(id).map(a -> new ModelMapper().map(a, AccountDto.class));
    }

    @PostMapping("")
    Mono<AccountDto> create(@RequestBody AccountDto newAccount) {
        Account account = new ModelMapper().map(newAccount, Account.class);
        return this.accountRepository.save(account).map(a -> new ModelMapper().map(a, AccountDto.class));
    }

    @PatchMapping("/{id}")
    Mono<AccountDto> updateAccount(@PathVariable long id, @RequestBody AccountDto account) {

        if (account.getId() == null) {
            throw new IllegalArgumentException("Valid account id must be provided");
        }

        if (id != account.getId()) {
            throw new IllegalArgumentException("Path id and body id must match");
        }

        return accountService.update(account).map(a -> new ModelMapper().map(a, AccountDto.class));
    }

}
