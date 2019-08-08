package com.springmongo.services;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.mongodb.DBCollection;
import com.mongodb.client.MongoCollection;
import com.springmongo.domain.Book;
import com.springmongo.repository.BookDao;

@Service 
public class BookService { 
	
	private final BookDao bookdao;

	@Autowired
	public BookService( @Qualifier("bookDaoQ") BookDao bookdao) {
		this.bookdao=bookdao;
	}
	
	public Book saveBook(Book book) {
		return bookdao.save(book);
	}

	public List<Book>  getAllBooks() {
		return bookdao.getAllBooks();
		
	}

	public void deleteBookById(Integer bookId) {
		 bookdao.delete(bookId);
	}
	
	public Book findBookById(Integer id) {
		return  bookdao.findById(id);
	}
	public Book updateBook(Book book) {
		return bookdao.update(book);
	}

	public Integer getMaxId(MongoCollection collection_name,String Id) {
		return bookdao.getMaxId(collection_name,Id);
	}

	public Book findBookByBookId(Integer bookId) {
		return  bookdao.findByBookId(bookId);
	}
	
	
	

}
