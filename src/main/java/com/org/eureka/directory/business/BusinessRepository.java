package com.org.eureka.directory.business;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BusinessRepository extends MongoRepository<Business, ObjectId> {
	Optional<Business>findBusinessByName(String name);

	Optional<List<Business>>findBusinessByCategory(Category name);

	Optional<List<Review>>findReviewsByBusinessName(Business name);
}
