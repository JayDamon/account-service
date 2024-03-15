package com.factotum.accountservice;

import io.zonky.test.db.AutoConfigureEmbeddedDatabase;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles({"test"})
@SpringBootTest
@WithMockUser
@AutoConfigureEmbeddedDatabase
class AccountServiceApplicationTests {

	@Test
	void contextLoads() {
	}

}
