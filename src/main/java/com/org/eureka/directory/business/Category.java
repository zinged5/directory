package com.org.eureka.directory.business;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "category")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category {
	@Id
	private ObjectId id;

	private String name;






}
