package com.example.Alposbookstore;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.assertj.core.api.Assertions.*;

import com.example.Alposbookstore.web.BookController;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class AlposbookstoreApplicationTests {

	@Autowired
	private BookController controller;
	
	@Test
	void contextLoads() throws Exception{
		assertThat(controller).isNotNull();
	}

}
