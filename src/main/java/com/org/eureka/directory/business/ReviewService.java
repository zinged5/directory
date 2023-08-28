package com.org.eureka.directory.business;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Map;

@Service
public class ReviewService {
	@Autowired ReviewRepository repository;

	@Autowired
	private MongoTemplate mongoTemplate;

	public Review createReview(String reviewBody, String name) throws JsonProcessingException {

		Review review = new ObjectMapper().readValue(reviewBody, Review.class);
		repository.insert(review);

		mongoTemplate.update(Business.class)
				.matching(Criteria.where("name").is(name))
				.apply(new Update().push("review").value(reviewBody))
				.first();

		return review;
	}
}
