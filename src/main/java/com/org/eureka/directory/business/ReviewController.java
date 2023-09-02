package com.org.eureka.directory.business;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.type.MapLikeType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static com.fasterxml.jackson.databind.type.LogicalType.Map;

@RestController
@RequestMapping("/business")
public class ReviewController {
	@Autowired
	private BusinessService service;

	@Autowired
	private ReviewService reviewService;


	@GetMapping("/{name}/reviews")
	public ResponseEntity <List<Review>> getReviews(@PathVariable String name) {
		return new ResponseEntity <List<Review>>( service.getReviews(name), HttpStatus.OK);
	}
		@PostMapping("/{name}/reviews/create")
		public ResponseEntity<Review>createReview (@RequestBody Map<String,String> payload) throws JsonProcessingException {
			return new ResponseEntity<Review>(reviewService.createReview(payload), HttpStatus.OK);
		};

	};
