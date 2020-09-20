package com.example.demo;



import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

public class IndexGeneratorService {
	
	private MongoOperations mongoOpertaions;
	
	@Autowired
	public IndexGeneratorService(MongoOperations mongoOpertaions) {
		this.mongoOpertaions = mongoOpertaions;
	}

	public long generateIndex(String indexName) {
		Query query = new Query(Criteria.where("_id").is(indexName));
		Update update = new Update().inc("index", 1);
		FindAndModifyOptions options = FindAndModifyOptions.options().returnNew(true).upsert(true);
		IndexGenerator index= mongoOpertaions.findAndModify(query, update, options, IndexGenerator.class);
		return Objects.isNull(index) ?1:index.getIndex();
		
	}
}
