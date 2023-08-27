package com.org.eureka.directory.business;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.Date;
import java.util.List;

@Document(collection = "business")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Business {
	@Id
	private ObjectId id;
	private String name;
	private List<Category> categories;
	private Date established;
	private String website;

	private List<String> services;
	@DocumentReference
	private List<Review> reviews;

	public Business(String name, List<Category> categories, Date established, String website, List<String> services, List<Review> reviews) {
		this.name = name;
		this.categories = categories;
		this.established = established;
		this.website = website;
		this.services = services;
		this.reviews = reviews;
	}

}
