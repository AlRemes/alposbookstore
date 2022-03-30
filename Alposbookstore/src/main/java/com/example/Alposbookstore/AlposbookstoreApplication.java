package com.example.Alposbookstore;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import com.example.Alposbookstore.model.Book;
import com.example.Alposbookstore.model.BookRepository;
import com.example.Alposbookstore.model.Category;
import com.example.Alposbookstore.model.CategoryRepository;
import com.example.Alposbookstore.model.UserDetailServiceImpl;
import com.example.Alposbookstore.model.UserRepository;
import com.example.Alposbookstore.model.User;

@SpringBootApplication
public class AlposbookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(AlposbookstoreApplication.class);


	public static void main(String[] args) {
		SpringApplication.run(AlposbookstoreApplication.class, args);
	}

	
	

	
	@Bean
	public CommandLineRunner bookDemo(BookRepository repository, CategoryRepository cRepository, UserRepository uRepository) {
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

			User user1 = new User("user",
					"$2a$10$AnFURN2yMJLV95PTDmCiYO8Xh5xaBDavZhZhPzrZRRnNjfjsED/Ze", "USER");
					User user2 = new User("admin",
					"$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN");
				
				
				
					//uRepository.save(user1);
					//uRepository.save(user2);
			
		};
}}
