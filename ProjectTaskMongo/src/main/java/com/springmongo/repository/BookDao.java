package com.springmongo.repository;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.Query;

import com.mongodb.DBCollection;
import com.mongodb.client.MongoCollection;
import com.springmongo.domain.Book;

public interface BookDao {

	Book  save(Book book);

	List<Book> getAllBooks();

	void delete(Integer bookId);

	Book findById(Integer bookId);

	Book update(Book book);
	
	//@Query("Select max(bookid) as bookid from Book")
	Integer getMaxId(MongoCollection collection_name,String Id);

	Book findByBookId(Integer bookId);

}