package com.factotum.setzer.controller;

import com.factotum.setzer.dto.AccountDto;
import com.factotum.setzer.dto.AccountTypeDto;
import com.factotum.setzer.repository.AccountRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.reactive.server.EntityExchangeResult;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import java.io.IOException;
import java.math.BigDecimal;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;

@ActiveProfiles({"test"})
@SpringBootTest
@AutoConfigureWebTestClient
@WithMockUser
class AccountControllerIT {

    private static final String URI = "/v1/accounts";

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private WebTestClient webTestClient;

    private AccountDto accountDto;

    @BeforeEach
    void setUp() {
        AccountTypeDto accountTypeDto = new AccountTypeDto();
        accountTypeDto.setId(2);
        accountTypeDto.setFullName("Savings");
        accountTypeDto.setShortName("Savings");

        accountDto = new AccountDto();
        accountDto.setId(1L);
        accountDto.setName("NewName");
        accountDto.setAccountType(accountTypeDto);
        accountDto.setStartingBalance(BigDecimal.valueOf(500.01));
        accountDto.setCurrentBalance(BigDecimal.valueOf(200));
        accountDto.setIsPrimaryAccount(false);
        accountDto.setIsInCashFlow(false);
    }

    @Test
    void getAllAccounts_GivenAccountsExist_ThenReturnAccounts() {

        webTestClient.get()
                .uri(URI)
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(AccountDto.class).hasSize(6);

    }

    @Test
    void getAccountById_GivenAccountExists_ThenReturnAccount() {

        webTestClient.get()
                .uri(URI + "/{id}", 1L)
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.id").value(is(greaterThan(0)))
                .jsonPath("$.name").isEqualTo("My Checking")
                .jsonPath("$.startingBalance").isEqualTo(500.01)
                .jsonPath("$.currentBalance").isEqualTo(8000.56)
                .jsonPath("$.isPrimary").isEqualTo(true)
                .jsonPath("$.isInCashFlow").isEqualTo(true)
                .jsonPath("$.type").exists()
                .jsonPath("$.type.id").isEqualTo(1);

    }

    @Test
    void createNewAccount_GivenValidAccountProvided_ThenReturnCreatedAccount() throws IOException {

        this.accountDto.setId(null);
        this.accountDto.setCurrentBalance(null);

        EntityExchangeResult<byte[]> result =  webTestClient.post()
                .uri(URI)
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(this.accountDto))
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.id").value(is(greaterThan(0)))
                .jsonPath("$.name").isEqualTo(this.accountDto.getName())
                .jsonPath("$.startingBalance").isEqualTo(this.accountDto.getStartingBalance().doubleValue())
                .jsonPath("$.isPrimary").isEqualTo(this.accountDto.getIsPrimaryAccount())
                .jsonPath("$.isInCashFlow").isEqualTo(this.accountDto.getIsInCashFlow())
                .jsonPath("$.type").exists()
                .jsonPath("$.type.id").isEqualTo(this.accountDto.getAccountType().getId())
                .returnResult();

        JsonNode node = new ObjectMapper().readTree(result.getResponseBody());

        accountRepository.deleteById(node.get("id").asLong()).block();
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

    @Test
    void updateAccount_GivenAccountIdMissing_ThenReturnBadRequest() {

        AccountTypeDto accountType = new AccountTypeDto();
        accountType.setId(3);

        AccountDto account = new AccountDto();
        account.setAccountType(accountType);

        webTestClient.patch()
                .uri(URI + "/{id}", 1)
                .body(BodyInserters.fromValue(account))
                .exchange()
                .expectStatus().isBadRequest();

    }

//    @Test
//    void updateAccount_GivenAccountDoesNotExist_ThenReturnBadRequest() {
//
//        AccountTypeDto accountType = new AccountTypeDto();
//        accountType.setId(3);
//
//        AccountDto account = new AccountDto();
//        account.setId(8021L);
//        account.setAccountType(accountType);
//
//        webTestClient.patch()
//                .uri(URI + "/{id}", account.getId())
//                .body(BodyInserters.fromValue(account))
//                .exchange()
//                .expectStatus().isBadRequest();
//
//    }

}
