package com.factotum.setzer.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.reactive.server.EntityExchangeResult;
import org.springframework.test.web.reactive.server.WebTestClient;

import static com.jayway.jsonpath.matchers.JsonPathMatchers.hasJsonPath;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasSize;

@ActiveProfiles({"test"})
@SpringBootTest
@AutoConfigureWebTestClient
public class AccountTypeControllerIT {

    private static final String URI = "/v1/account-types";

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void getAccountTypes_GivenTypesExist_ThenReturnAllTypes() throws Exception {

        EntityExchangeResult<byte[]> result =  webTestClient.get()
                .uri(URI)
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.[*]").value(hasSize(greaterThan(0)))
                .returnResult();

        JsonNode node = new ObjectMapper().readTree(result.getResponseBody());
        for (JsonNode n : node) {

            String json = n.toString();

            System.out.println(json);

            assertThat(json, hasJsonPath("$.fullName"));
            assertThat(json, hasJsonPath("$.shortName"));

        }
    }

}
