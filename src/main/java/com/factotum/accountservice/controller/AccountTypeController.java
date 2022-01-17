package com.factotum.accountservice.controller;

import com.factotum.accountservice.model.AccountType;
import com.factotum.accountservice.repository.AccountTypeRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/v1/accounts/types")
public class AccountTypeController {

    private final AccountTypeRepository accountTypeRepository;

    public AccountTypeController(AccountTypeRepository accountTypeRepository) {
        this.accountTypeRepository = accountTypeRepository;
    }

    @GetMapping("")
    Flux<AccountType> getAccountTypes() {
        return accountTypeRepository.findAll();
    }

}
