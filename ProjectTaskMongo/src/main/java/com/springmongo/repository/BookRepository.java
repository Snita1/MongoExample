package com.springmongo.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.springmongo.domain.Book;

public interface BookRepository extends  MongoRepository<Book, Integer> {

}
