package com.factotum.setzer;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles({"test"})
@SpringBootTest
@WithMockUser
class SetzerApplicationTests {

	@Test
	void contextLoads() {
	}

}
