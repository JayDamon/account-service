package com.factotum.accountservice.controller;

import com.factotum.accountservice.dto.AccountDto;
import com.factotum.accountservice.repository.AccountRepository;
import com.factotum.accountservice.util.SecurityTestUtil;
import io.zonky.test.db.AutoConfigureEmbeddedDatabase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

import java.math.BigDecimal;
import java.util.UUID;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.nullValue;
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
        accountDto = new AccountDto();
        accountDto.setId(accountIdOne);
        accountDto.setName("NewName");
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
                .jsonPath("$.limit").doesNotExist()
                .jsonPath("$.availableBalance").isEqualTo(8000.56)
                .jsonPath("$.accountType").isEqualTo("depository")
                .jsonPath("$.accountSubType").isEqualTo("checking");

    }

    // updateAccountName
    @Test
    void updateAccountName_GivenAccountExists_ThenUpdateFieldsName() {

        AccountDto account = new AccountDto();
        account.setId(accountIdOne);

        webTestClient
                .mutateWith(mockJwt().jwt(SecurityTestUtil.getTestJwt()))
                .patch()
                .uri(URI + "/{id}/name", accountIdOne)
                .body(BodyInserters.fromValue(account))
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .consumeWith(System.out::println);

    }

    @Test
    void updateAccountName_GivenAccountNameIdMissing_ThenReturnBadRequest() {

        AccountDto account = new AccountDto();

        webTestClient
                .mutateWith(mockJwt().jwt(SecurityTestUtil.getTestJwt()))
                .patch()
                .uri(URI + "/{id}/name", accountIdOne)
                .body(BodyInserters.fromValue(account))
                .exchange()
                .expectStatus().isBadRequest();

    }

}
