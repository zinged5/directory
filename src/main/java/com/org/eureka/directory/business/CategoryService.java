package com.org.eureka.directory.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
	@Autowired
	private CategoryRepository repository;

	@Autowired
	private BusinessRepository businessRepository;

	@Autowired
	private MongoTemplate mongoTemplate;

	public List<Category> findAllCategories() {
		return repository.findAll();
	}
	public Category findCategoryByName(String name) {
		Query query =  new Query();
		query.addCriteria(Criteria.where("name").regex(name));
		query.limit(1).toString();
		Category category = mongoTemplate.findOne(query,Category.class);

		return category;
	};



}
