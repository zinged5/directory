package com.org.eureka.directory.business;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
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

	public Optional<List<Business>> findBusinessByCategory(Category name){return repository.findBusinessByCategory(name);};

	public Optional<List<Review>> findReviewsByBusinessName(Business name){return repository.findReviewsByBusinessName(name);};

}
