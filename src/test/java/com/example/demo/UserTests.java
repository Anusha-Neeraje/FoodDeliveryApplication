package com.example.demo;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserTests {
	
	@Autowired
	private UserRepository userRepo;
	
	
	@Test
	public void testCreateUser() {
		User usr1 = new User();
		usr1.setName("Anu");
		usr1.setEmail("anu12@gmail.com");
		usr1.setPassword("an1234");
		usr1.setCpassword("an1234");
		userRepo.save(usr1);
		Assertions.assertThat(usr1.getId()).isGreaterThan(0);
	}
	
	@Test
	public void testNCreateUser() {
		User usr1 = new User();
		usr1.setName("");
		usr1.setEmail("anu12@gmail.com");
		usr1.setPassword("an1234");
		usr1.setCpassword("an1234");
		userRepo.save(usr1);
		Assertions.assertThat(usr1.getName()).isNotEmpty();
	}
}
