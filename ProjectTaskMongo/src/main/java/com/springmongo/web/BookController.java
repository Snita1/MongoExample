package com.springmongo.web;

import java.util.ArrayList;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mongodb.DB;
import com.springmongo.domain.Book;
import com.springmongo.errors.ErrorException;
import com.springmongo.services.BookService;
import com.springmongo.services.SequenceGeneratorService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/BookStore")
public class BookController {

	private static final Logger logger = LoggerFactory.getLogger(BookController.class);

	@Autowired
	private BookService bookservice;

	@PostMapping(value = "/AddBook", consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<?> addbook(@RequestBody Book book) {
		logger.info("Book added " + book);
		//book.setBookId(bookservice.getMaxId());
		bookservice.getMaxId(Book,"bookId");
		Book newBook = bookservice.saveBook(book);
		return new ResponseEntity<Book>(newBook, HttpStatus.CREATED);
	}

	@GetMapping(value = "/GetBooks") // ,consumes = {MediaType.APPLICATION_JSON_VALUE,//
										// MediaType.APPLICATION_XML_VALUE})

	public List<?> showUsers() {

		logger.info("Returning all the Books");

		List<Book> booklist = bookservice.getAllBooks();

		return booklist;

	}

	@GetMapping(value = "/GetBooksById/{bookId}") // ,consumes = {MediaType.APPLICATION_JSON_VALUE,
	// MediaType.APPLICATION_XML_VALUE})

	public Book showBooksById(@PathVariable Integer bookId) throws ErrorException {
		logger.info("Book id to show " + bookId);

		Book book = bookservice.findBookById(bookId);
		if (book == null || book.getBookId() == null) {
			throw new ErrorException("Book doesn´t exist");
		}
		List<Book> booklist = new ArrayList<>();
		booklist.add(book);

		return book;

	}

	@PutMapping(value = "/UpdateBooks/{bookId}")
	public Book updateBook(@RequestBody Book book) throws ErrorException {
		logger.info("Book id to update " + book.getBookId());
		Book booktoupdate = bookservice.findBookByBookId(book.getBookId());
		
		if (booktoupdate == null || booktoupdate.getBookId() == null ) {
	
			throw new ErrorException("Book doesn´t exist");
		}
		Book updatedbook = bookservice.updateBook(book);
		logger.info("Book updated:" + updatedbook.toString());
		return updatedbook;

	}

	@DeleteMapping(value = "/DeleteBook/{bookId}")
	public void deleteBook(@PathVariable Integer bookId) throws ErrorException {

		logger.info("Book id to delete " + bookId);

		Book book = bookservice.findBookById(bookId);
		if (bookId == null) {
			throw new ErrorException("Book  doesn´t exist");
		}

		bookservice.deleteBookById(bookId);

	}

}
