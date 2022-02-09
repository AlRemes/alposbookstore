package com.example.Alposbookstore.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.Alposbookstore.model.Book;
import com.example.Alposbookstore.model.BookRepository;


@Controller
public class BookController {
	
	ArrayList<Book> books = new ArrayList<>();
	
	@Autowired
	private BookRepository repository;

	@RequestMapping(value= {"/", "/index"})
	public String index() {
		return "index";
	}
	
	@RequestMapping(value= {"/booklist"})
	public String listbooks(Model model) {
		model.addAttribute("books", repository.findAll());
		return "listbooks";
	}

	@RequestMapping(value = "/add")
	public String addBook(Model model){
	 model.addAttribute("book", new Book());
	 return "addbook";
	}
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Book book){
	 repository.save(book);
	 return "redirect:booklist";
	}

}
