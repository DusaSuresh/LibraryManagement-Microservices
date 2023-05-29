package com.library.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.library.model.Book;
import com.library.service.BookService;

@RestController
@RequestMapping("/books")
public class BookController {

	@Autowired
	private BookService bookService;

	private static final Logger logger = LoggerFactory.getLogger(BookController.class);

	@GetMapping()
	public List<Book> getBooks() {
		logger.info(" Listing all the available books in library {} -- getBooks() method -- BookController");
		return bookService.getBooks();
	}
	
	@PostMapping()
	public Book addBook(@RequestBody Book book) {
		return bookService.addBookInLibrary(book);
	}
	
	@GetMapping("/books/details/{id}")
	public Book getBook(@RequestParam Long id) {
		
		return bookService.getBook(id).get();
	}
	
	@PutMapping("/books/update/{id}")
	public Book updateBook(@RequestParam Long id, @RequestBody Book book) {
		return bookService.updateBook(id, book);
	}
	
	@DeleteMapping("/books/delete/{id}")
	public String deleteBook(@RequestParam Long id) {
		return bookService.deleteBook(id);
	}
	
	@GetMapping("/books/search/{searchKeyWord")
	public List<Book> searchBook(@RequestParam String searchBook) {
		return bookService.searchBook(searchBook);
	}

}
