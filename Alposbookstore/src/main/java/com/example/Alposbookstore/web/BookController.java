package com.example.Alposbookstore.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.Alposbookstore.model.Book;
import com.example.Alposbookstore.model.BookRepository;
import com.example.Alposbookstore.model.CategoryRepository;


@Controller
public class BookController {
	
	ArrayList<Book> books = new ArrayList<>();
	
	@Autowired
	private BookRepository repository;
	@Autowired
	private CategoryRepository Crepository;

	@RequestMapping(value="/login")
	public String login() {
		return "login";
	}
	
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
	 model.addAttribute("categories", Crepository.findAll());
	 return "addbook";
	}
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Book book){
	 repository.save(book);
	 return "redirect:booklist";
	}
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	@PreAuthorize("hasRole('ADMIN')")
	public String deleteBook(@PathVariable("id") Long BookId, Model model) {
	 repository.deleteById(BookId);
	 return "redirect:../booklist";
	}
	@RequestMapping(value = "/edit/{id}")
	public String getBook(@PathVariable("id") Long bookId, Model model){
	model.addAttribute("book", repository.findById(bookId));
	model.addAttribute("categories", Crepository.findAll());
	return "edit";
	}
	@RequestMapping(value = "edit/savebook", method = RequestMethod.POST)
	public String edit(Book book){
	 repository.save(book);
	 return "redirect:../booklist";
	}
	
	@RequestMapping(value = "/books", method = RequestMethod.GET)
	public @ResponseBody List<Book> BooksRest(){
		return (List<Book>) repository.findAll();
	}
	@RequestMapping(value = "/book/{id}", method = RequestMethod.GET)
	public @ResponseBody Book FindBookId(@PathVariable("id") Long id){
		Optional<Book> optionalBook = repository.findById(id);
		return optionalBook.get();
	}
	
	@RequestMapping(value= {"/logout"})
	public String logout() {
		return "redirect:/login?logout";
	}

}
