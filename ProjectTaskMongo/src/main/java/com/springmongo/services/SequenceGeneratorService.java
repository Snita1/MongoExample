package com.springmongo.services;

import static org.springframework.data.mongodb.core.FindAndModifyOptions.options;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.springmongo.domain.DatabaseSequence;

@Service
public class SequenceGeneratorService {
	@Autowired private static MongoOperations mongo;
	public static Integer generateSequence(String seqName) {
	    DatabaseSequence counter =mongo.findAndModify(
	            query(where("id").is(seqName)),
	            new Update().inc("seq",1),
	            options().returnNew(true).upsert(true),
	            DatabaseSequence.class);
	    return counter.getSeq();
	}

	
}
