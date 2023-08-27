package com.org.eureka.directory.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ReviewService {
	@Autowired ReviewRepository repository;

	@Autowired
	private MongoTemplate mongoTemplate;

	public Review createReview(Review reviewObj) {
		Review review = repository.insert(reviewObj);

		mongoTemplate.update(Business.class)
				.matching(Criteria.where("name").is(reviewObj.getBusinessName()))
				.apply(new Update().push("review").value(review.getComment()))
				.first();

		return review;
	}
}
