package com.springmongo.domain;

import org.bson.types.ObjectId;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Book")
public class Book {
	
	@Id
	private ObjectId _id;
	//@Indexed(name = "bookId_index", direction = IndexDirection.DESCENDING)
	 @Transient
	    public static final String SEQUENCE_NAME = "book_sequence";
	
	private Integer bookId;
	
	private String bookName;
	private String authorName;
	public Book(ObjectId _id, Integer bookId,String bookName, String authorName) {//
		super();
		//this._id = _id;
		 this.bookId=bookId;
		this.bookName = bookName;
		this.authorName = authorName;
	}
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ObjectId getId() {
		return _id;
	}
	public void setId(ObjectId _id) {
		this._id = _id;
	}
	public Integer getBookId() {
		return bookId;
	}
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	
	

}
