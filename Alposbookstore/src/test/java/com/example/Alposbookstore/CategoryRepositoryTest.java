package com.example.Alposbookstore;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.Alposbookstore.model.Category;
import com.example.Alposbookstore.model.CategoryRepository;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class CategoryRepositoryTest {
@Autowired
private CategoryRepository cRepository;

@Test
public void findByNameReturnsCategory() {
	List<Category> categories = cRepository.findByName("Fantasy");
	assertThat(categories).hasSize(1);
}
@Test
public void deleteById() {
	long id = 1;
	assertThat(cRepository.findById(id)).isNotEmpty();
	cRepository.deleteById(id);
	assertThat(cRepository.findById(id)).isEmpty();
}
}
