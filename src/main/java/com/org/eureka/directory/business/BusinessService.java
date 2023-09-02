package com.org.eureka.directory.business;


import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Projections;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ExecutableFindOperation;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.LookupOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.mongodb.client.model.Projections.include;
import static org.springframework.data.mongodb.core.query.Criteria.where;

@Service
public class BusinessService {
	@Autowired
	private BusinessRepository repository;

	@Autowired
	private MongoTemplate mongoTemplate;

	public List<Business> findAllBusinesses() {
		return repository.findAll();
	}
	public Optional<Business> findBusinessByName(String name) {
		return repository.findBusinessByName(name);
	};
	public List<Business> findBusinessesByCategory(String name) {
		Query query =  new Query();
//		query.addCriteria(Criteria.where("category").regex(name));
		query.addCriteria(where("categories").in(name));
		List<Business> businessesWithCategory = mongoTemplate.find(query,Business.class);

		return businessesWithCategory;
	};


//	public Optional<List<Business>> findBusinessByCategory(String name){return repository.findBusinessByCategory(name);};
	public List<Review> getReviews(String name){
		LookupOperation lookup = LookupOperation.newLookup()
				.from("review")
				.localField("reviews")
				.foreignField("_id")
				.as("reviews");


		Aggregation aggregation = Aggregation.newAggregation(
				 lookup );

		return mongoTemplate.aggregate(aggregation, "review",
				Review.class).getMappedResults();


};
}
