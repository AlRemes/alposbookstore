package com.example.Alposbookstore;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import com.example.Alposbookstore.model.Book;
import com.example.Alposbookstore.model.BookRepository;
import com.example.Alposbookstore.model.Category;
import com.example.Alposbookstore.model.CategoryRepository;

@SpringBootApplication
public class AlposbookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(AlposbookstoreApplication.class);


	public static void main(String[] args) {
		SpringApplication.run(AlposbookstoreApplication.class, args);
	}

	@Bean
	public UserDetailsService userDetailsService() {
	UserDetails user = User.withDefaultPasswordEncoder()
	.username("user")
	.password("password")
	.roles("USER")
	.build();
	UserDetails admin = User.withDefaultPasswordEncoder()
	.username("admin")
	.password("admin")
	.roles("ADMIN")
	.build();
	List<UserDetails> users = new ArrayList();
	users.add(user);
	users.add(admin);
	return new InMemoryUserDetailsManager(users);
	}
	
	@Bean
	public CommandLineRunner bookDemo(BookRepository repository, CategoryRepository cRepository) {
		return (args) -> {
			log.info("save some books");
			cRepository.save(new Category("Fantasy"));
			cRepository.save(new Category("Romance"));
			
			repository.save(new Book("Book1", "Luke", 1999, "1231", 12, cRepository.findByName("Fantasy").get(0)));
			repository.save(new Book("Book2", "Luce", 1998, "1232", 15, cRepository.findByName("Romance").get(0)));
			
			log.info("fetch all students");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}

		};
}}
