package com.factotum.setzer.controller;

import com.factotum.setzer.dto.AccountDto;
import com.factotum.setzer.dto.AccountTypeDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

@ActiveProfiles({"test"})
@SpringBootTest
@AutoConfigureWebTestClient
class AccountControllerIT {

    private static final String URI = "/v1/accounts";

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void getAllAccounts_GivenAccountsExist_ThenReturnAccounts() {

        webTestClient.get()
                .uri(URI)
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(AccountDto.class).hasSize(6);

    }

    @Test
    void updateAccount_GivenAccountExists_ThenUpdateFields() {

        AccountTypeDto accountType = new AccountTypeDto();
        accountType.setId(3);

        AccountDto account = new AccountDto();
        account.setId(1L);
        account.setAccountType(accountType);

        webTestClient.patch()
                .uri(URI + "/{id}", 1)
                .body(BodyInserters.fromValue(account))
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.type.id").isEqualTo(3);

    }

}
