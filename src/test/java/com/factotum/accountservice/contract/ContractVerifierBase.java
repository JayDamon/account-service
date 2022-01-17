package com.factotum.accountservice.contract;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.reactive.server.WebTestClient;

@ActiveProfiles({"test"})
@SpringBootTest
@AutoConfigureWebTestClient
public class ContractVerifierBase {

    @Autowired
    WebTestClient webTestClient;

//    @Autowired
//    private WebApplicationContext context;
//
//
//    @BeforeEach
//    void setup() {
//        RestAssuredWeb.webAppContextSetup(context);
//    }

}
