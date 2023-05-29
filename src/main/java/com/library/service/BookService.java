package com.library.service;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.library.model.Book;
import com.library.repository.BookRepository;

public class BookService {
	
	private static final Logger logger = LoggerFactory.getLogger(BookService.class);
	
	@Autowired
	private BookRepository bookRepository;
	
	public List<Book> getBooks() {
		logger.info(" {} getBooks method calling in BookService");
		return bookRepository.findAll();
	}

	public Book addBookInLibrary(Book book) {
		logger.info(" {} addBookInLibrary method calling in BookService", book);
		return bookRepository.save(book);
	}

	public Optional<Book> getBook(Long id) {
		logger.info(" {} getBook method calling in BookService", id);
		return bookRepository.findById(id);
	}

	public Book updateBook(Long id, Book book) {
		logger.info(" {} updateBook method calling in BookService", id);
		Book bookDetails = bookRepository.findById(id).get();
		bookDetails.setAuthor(book.getAuthor());
		bookDetails.setIsbn(book.getIsbn());
		bookDetails.setTitle(book.getTitle());
		return bookRepository.save(bookDetails);
	}

	public String deleteBook(Long id) {
		logger.info(" {} deleteBook method calling in BookService", id);
		bookRepository.deleteById(id);
		return "Book deleted successfully";
	}

	public List<Book> searchBook(String searchBook) {
		// TODO Auto-generated method stub
		return bookRepository.search(searchBook);
	}

}
