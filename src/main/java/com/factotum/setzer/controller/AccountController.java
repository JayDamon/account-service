package com.factotum.setzer.controller;

import com.factotum.setzer.model.Account;
import com.factotum.setzer.repository.AccountRepository;
import com.factotum.setzer.service.AccountService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

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
    Flux<Account> getAccountRepository() {
        return this.accountRepository.findAll();
    }

    @PostMapping("")
    Mono<Account> create(@RequestBody Account account) {
        return this.accountRepository.save(account);
    }

    @PatchMapping("/{id}")
    Mono<Account> updateAccount(@PathVariable long id, @RequestBody Account account) {

        if (id != account.getId()) {
            throw new IllegalArgumentException("Path id and body id must match");
        }

        return accountService.save(account);
    }

}
