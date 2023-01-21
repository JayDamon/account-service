package com.factotum.accountservice.controller;

import com.factotum.accountservice.dto.AccountDto;
import com.factotum.accountservice.dto.AccountTypeDto;
import com.factotum.accountservice.repository.AccountRepository;
import com.factotum.accountservice.util.SecurityTestUtil;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.zonky.test.db.AutoConfigureEmbeddedDatabase;
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
import java.util.UUID;

import static org.hamcrest.Matchers.*;
import static org.springframework.security.test.web.reactive.server.SecurityMockServerConfigurers.mockJwt;

@ActiveProfiles({"test"})
@SpringBootTest
@AutoConfigureWebTestClient
@WithMockUser
@AutoConfigureEmbeddedDatabase
class AccountControllerIntegrationTest {

    private static final String URI = "/v1/accounts";

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private WebTestClient webTestClient;

    private AccountDto accountDto;

    private static final UUID accountTypeIdOne = UUID.fromString("09a3b555-ea95-4f5b-a4e5-660d5f3657e5");
    private static final UUID accountTypeIdTwo = UUID.fromString("e20209f2-9ec6-40f8-9478-ac0e5dd91c7b");
    private static final UUID accountTypeIdThree = UUID.fromString("105e53a4-a1cd-4b2e-97fc-82faae39d355");
    private static final UUID accountIdOne = UUID.fromString("43b38f84-ed18-4801-803f-2f4be3119d3f");

    @BeforeEach
    void setUp() {
        AccountTypeDto accountTypeDto = new AccountTypeDto();
        accountTypeDto.setId(accountTypeIdTwo);
        accountTypeDto.setFullName("Savings");
        accountTypeDto.setShortName("Savings");

        accountDto = new AccountDto();
        accountDto.setId(accountIdOne);
        accountDto.setName("NewName");
        accountDto.setAccountType(accountTypeDto);
        accountDto.setStartingBalance(BigDecimal.valueOf(500.01));
        accountDto.setCurrentBalance(BigDecimal.valueOf(200));
        accountDto.setIsPrimaryAccount(false);
        accountDto.setIsInCashFlow(false);
    }

    // getAllAccounts
    @Test
    void getAllAccounts_GivenAccountsExist_ThenReturnAccounts() {

        webTestClient
                .mutateWith(mockJwt().jwt(SecurityTestUtil.getTestJwt()))
                .get()
                .uri(URI)
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(AccountDto.class).hasSize(6);

    }

    // getAccountById
    @Test
    void getAccountById_GivenAccountExists_ThenReturnAccount() {

        webTestClient
                .mutateWith(mockJwt().jwt(SecurityTestUtil.getTestJwt()))
                .get()
                .uri(URI + "/{id}", accountIdOne)
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .consumeWith(System.out::println)
                .jsonPath("$.id").value(is(not(nullValue())))
                .jsonPath("$.name").isEqualTo("My Checking")
                .jsonPath("$.startingBalance").isEqualTo(500.01)
                .jsonPath("$.currentBalance").isEqualTo(8000.56)
                .jsonPath("$.isPrimary").isEqualTo(true)
                .jsonPath("$.isInCashFlow").isEqualTo(true)
                .jsonPath("$.type").exists()
                .jsonPath("$.type.id").isEqualTo(accountTypeIdOne.toString());

    }

    // createNewAccount
    @Test
    void createNewAccount_GivenValidAccountProvided_ThenReturnCreatedAccount() throws IOException {

        this.accountDto.setId(null);
        this.accountDto.setCurrentBalance(null);

        EntityExchangeResult<byte[]> result =  webTestClient
                .mutateWith(mockJwt().jwt(SecurityTestUtil.getTestJwt()))
                .post()
                .uri(URI)
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(this.accountDto))
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.id").value(not(nullValue()))
                .jsonPath("$.name").isEqualTo(this.accountDto.getName())
                .jsonPath("$.startingBalance").isEqualTo(this.accountDto.getStartingBalance().doubleValue())
                .jsonPath("$.isPrimary").isEqualTo(this.accountDto.getIsPrimaryAccount())
                .jsonPath("$.isInCashFlow").isEqualTo(this.accountDto.getIsInCashFlow())
                .jsonPath("$.type").exists()
                .jsonPath("$.type.id").isEqualTo(this.accountDto.getAccountType().getId().toString())
                .returnResult();

        JsonNode node = new ObjectMapper().readTree(result.getResponseBody());

        accountRepository.deleteById(UUID.fromString(node.get("id").asText())).block();
    }

    @Test
    void createNewAccount_GivenAccountMissingName_ThenReturnBadRequest() {

        this.accountDto.setId(null);
        this.accountDto.setCurrentBalance(null);
        this.accountDto.setName(null);

        webTestClient
                .mutateWith(mockJwt().jwt(SecurityTestUtil.getTestJwt()))
                .post()
                .uri(URI)
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(this.accountDto))
                .exchange()
                .expectStatus().isBadRequest();
    }

    @Test
    void createNewAccount_GivenAccountMissingAccountType_ThenReturnBadRequest() {

        this.accountDto.setId(null);
        this.accountDto.setCurrentBalance(null);
        this.accountDto.setAccountType(null);

        webTestClient
                .mutateWith(mockJwt().jwt(SecurityTestUtil.getTestJwt()))
                .post()
                .uri(URI)
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(this.accountDto))
                .exchange()
                .expectStatus().isBadRequest();
    }

    @Test
    void createNewAccount_GivenAccountMissingStartingBalance_ThenReturnBadRequest() {

        this.accountDto.setId(null);
        this.accountDto.setCurrentBalance(null);
        this.accountDto.setStartingBalance(null);

        webTestClient
                .mutateWith(mockJwt().jwt(SecurityTestUtil.getTestJwt()))
                .post()
                .uri(URI)
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(this.accountDto))
                .exchange()
                .expectStatus().isBadRequest();
    }

    // updateAccount
    @Test
    void updateAccount_GivenAccountExists_ThenUpdateFields() {

        AccountTypeDto accountType = new AccountTypeDto();
        accountType.setId(accountTypeIdThree);

        AccountDto account = new AccountDto();
        account.setId(accountIdOne);
        account.setAccountType(accountType);

        webTestClient
                .mutateWith(mockJwt().jwt(SecurityTestUtil.getTestJwt()))
                .patch()
                .uri(URI + "/{id}", accountIdOne)
                .body(BodyInserters.fromValue(account))
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .consumeWith(System.out::println)
                .jsonPath("$.type.id").isEqualTo(accountTypeIdThree.toString());

    }

    @Test
    void updateAccount_GivenAccountIdMissing_ThenReturnBadRequest() {

        AccountTypeDto accountType = new AccountTypeDto();
        accountType.setId(accountTypeIdThree);

        AccountDto account = new AccountDto();
        account.setAccountType(accountType);

        webTestClient
                .mutateWith(mockJwt().jwt(SecurityTestUtil.getTestJwt()))
                .patch()
                .uri(URI + "/{id}", accountIdOne)
                .body(BodyInserters.fromValue(account))
                .exchange()
                .expectStatus().isBadRequest();

    }

}
