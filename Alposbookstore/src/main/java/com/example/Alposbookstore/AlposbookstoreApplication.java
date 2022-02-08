package com.example.Alposbookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.Alposbookstore.model.Book;
import com.example.Alposbookstore.model.BookRepository;

@SpringBootApplication
public class AlposbookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(AlposbookstoreApplication.class);


	public static void main(String[] args) {
		SpringApplication.run(AlposbookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner bookDemo(BookRepository repository) {
		return (args) -> {
			log.info("save some books");
			repository.save(new Book("Book1", "Luke", 1999, "1231", 12));
			repository.save(new Book("Book2", "Luce", 1998, "1232", 15));
			
			log.info("fetch all students");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}

		};
}}
