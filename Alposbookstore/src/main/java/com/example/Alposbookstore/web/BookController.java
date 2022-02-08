package com.example.Alposbookstore.web;

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
@ResponseBody
public class BookController {
	
	@Autowired
	private BookRepository repository;
	
	@RequestMapping(value= {"/", "/booklist"})
	public String listbooks(Model model) {
		model.addAttribute("students", repository.findAll());
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
	 return "redirect:studentlist";
	}

}
