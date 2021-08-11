package com.nisum.cms;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


//@SpringBootConfiguration

@RunWith(SpringRunner.class)
@SpringBootTest(classes = CartManagementApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class CartManagementApplicationTests {

	@Test
	void contextLoads() {
	}

}
