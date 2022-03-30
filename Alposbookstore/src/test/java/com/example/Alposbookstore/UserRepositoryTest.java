package com.example.Alposbookstore;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.Alposbookstore.model.User;
import com.example.Alposbookstore.model.UserRepository;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class UserRepositoryTest {
	@Autowired
	private UserRepository uRepository;
	
	@Test
	public void findByUsernameExists() {
		User user = uRepository.findByUsername("user");
		assertThat(user).isNotNull();
	}

	@Test
	public void createUser() {
		User user = new User("test",
				"$2a$10$AnFURN2yMJLV95PTDmCiYO8Xh5xaBDavZhZhPzrZRRnNjfjsED/Ze", "TEST");
		
		uRepository.save(user);
		assertThat(user.getUsername()).isNotNull();
	}
	@Test
	public void deleteById() {
		long id = 1;
		assertThat(uRepository.findById(id)).isNotEmpty();
		uRepository.deleteById(id);
		assertThat(uRepository.findById(id)).isEmpty();
	}
}
