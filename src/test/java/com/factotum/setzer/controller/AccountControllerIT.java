package com.factotum.setzer.controller;

import com.factotum.setzer.model.Account;
import com.factotum.setzer.model.AccountType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebFlux;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.BodyInserters;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

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
                .expectBodyList(Account.class).hasSize(6);

    }

    @Test
    void updateAccount_GivenAccountExists_ThenUpdateFields() {

        AccountType accountType = new AccountType();
        accountType.setId(3);

        Account account = new Account();
        account.setId(1L);
        account.setAccountType(accountType);

        webTestClient.patch()
                .uri(URI + "/{id}", 1)
                .body(BodyInserters.fromValue(account))
                .exchange()
                .expectStatus().isOk()
//                .returnResult(Account.class).getResponseBody().subscribe(System.out::println);
                .expectBody()
                .jsonPath("$.type.id").isEqualTo(3);

    }

}
