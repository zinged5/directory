package com.org.eureka.directory.business;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
		query.addCriteria(Criteria.where("categories").in(name));

		List<Business> businessesWithCategory = mongoTemplate.find(query,Business.class);

		return businessesWithCategory;
	};


//	public Optional<List<Business>> findBusinessByCategory(String name){return repository.findBusinessByCategory(name);};

//	public Optional<List<Review>> findReviewsByBusinessName(String name){return repository.findReviewsByBusinessName(name);};

}
