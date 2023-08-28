package com.org.eureka.directory.business;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.type.MapLikeType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static com.fasterxml.jackson.databind.type.LogicalType.Map;

@RestController
@RequestMapping("/business/")
public class ReviewController {
	@Autowired
	private BusinessService service;

	@Autowired
	private ReviewService reviewService;


//	@GetMapping("/business/{name}/reviews")
//	public ResponseEntity<Optional<List<Review>>> getReviews(@PathVariable String name) {
//		return new ResponseEntity<Optional<List<Review>>>(service.findReviewsByBusinessName(name), HttpStatus.OK);
//	}
		@PostMapping()
		public ResponseEntity<Review>createReview (@RequestBody Map<String,String> payload) throws JsonProcessingException {
			return new ResponseEntity<Review>(reviewService.createReview(payload.get("name"),payload.get("review")), HttpStatus.OK);
		};

	};
