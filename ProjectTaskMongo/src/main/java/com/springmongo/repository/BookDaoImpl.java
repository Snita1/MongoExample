package com.springmongo.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Qualifier;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.springmongo.domain.Book;

@Repository
@Qualifier("bookDaoQ")
public class BookDaoImpl implements BookDao {

	// @Autowired
	// private BookRepository bookRepo;

	private static final String COLLECTION = "Books";
	private final MongoTemplate mongoTemplate;

	@Autowired
	public BookDaoImpl(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

	@Override
	public Book save(Book book) {
		return mongoTemplate.save(book);
	}

	@Override
	public List<Book> getAllBooks() {
		// TODO Auto-generated method stub
		return mongoTemplate.findAll(Book.class);
	}

	@Override
	public Book update(Book book) {
		Query query = new Query(Criteria.where("bookId").is(book.getBookId()));
		Update update=new Update();
		update.set("bookName", book.getBookName());
		update.set("authorName", book.getAuthorName());
		update.set("bookId", book.getBookId());
		mongoTemplate.updateFirst(query, update, Book.class);
		return book;
	}
	@Override
	public void delete(Integer bookId) {
		Query query = new Query(Criteria.where("bookId").is(bookId));
		mongoTemplate.remove(query, Book.class);
	}

	@Override
	public Book findById(Integer id) {
		
		Query query = new Query(Criteria.where("bookId").is(id));
		return mongoTemplate.findOne(query, Book.class);
	}

	@Override
	public Integer getMaxId(MongoCollection collection_name,String Id) {
		
		//database.getCollection("COLLECTION_NAME");
		
		//MongoCollection<org.bson.Document> document=mongoTemplate.getCollection(collection_name);
		if (collection_name.find()==null)
		return 1;
		else
		{
			Query query = new Query();
			query.with(new Sort(Sort.Direction.DESC, Id));
			Book book= (Book) mongoTemplate.findOne(query, collection_name.getClass());
			return book.getBookId()+1;
		}
	
		/*System.out.println("book.getBookId()");
		Query query = new Query();
		query.with(new Sort(Sort.Direction.DESC, "bookId"));
		Book book=mongoTemplate.findOne(query, Book.class);
		//System.out.println(book.getBookId());
		if (book==null) {
			return 1;
		}
		else
		return book.getBookId()+1;*/
		
		
			

	}

	@Override
	public Book findByBookId(Integer bookId) {
		// TODO Auto-generated method stub
		Query query = new Query();
		/query.
		return mongoTemplate.find(query, Book.class)
	}

}
