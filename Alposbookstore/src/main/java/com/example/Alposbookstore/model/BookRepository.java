package com.example.Alposbookstore.model;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long>{
	List<Book> findByTitle(String title);
	//void deleteById(long id);
}
