package com.example.Alposbookstore;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.assertj.core.api.Assertions.*;

import com.example.Alposbookstore.model.Book;
import com.example.Alposbookstore.model.BookRepository;
import com.example.Alposbookstore.model.Category;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class BookRepositoryTest {
	@Autowired
	private BookRepository repository;
	
	@Test
	public void findByTitleShouldReturnBook() {
		List<Book> books = repository.findByTitle("Book1");
		assertThat(books).hasSize(1);
		assertThat(books.get(0).getAuthor()).isEqualTo("Luke");
	}

	@Test
	public void createBook() {
		Book book = new Book("Test", "Author", 2000, "2555", 20, new Category("Action"));
		repository.save(book);
		assertThat(book.getId()).isNotNull();
	}
	
	@Test
	public void deleteById() {
		long id = 3;
		assertThat(repository.findById(id)).isNotEmpty();
		repository.deleteById(id);
		assertThat(repository.findById(id)).isEmpty();
	}
}
