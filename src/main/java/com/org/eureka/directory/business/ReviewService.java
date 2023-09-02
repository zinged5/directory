package com.org.eureka.directory.business;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
public class ReviewService {
	@Autowired ReviewRepository repository;

	@Autowired
	private MongoTemplate mongoTemplate;

	public Review createReview( Map<String,String> reviewBody) throws JsonProcessingException {
		Review review = new Review(reviewBody.get("comment").toString(),Boolean.parseBoolean(reviewBody.get("recommend").toString()),LocalDateTime.now(),LocalDateTime.now());
		repository.insert(review);

		mongoTemplate.update(Business.class)
				.matching(Criteria.where("name").is(reviewBody.get("name")))
				.apply(new Update().push("reviewId").value(review.getId()));

		return review;
	}
}
