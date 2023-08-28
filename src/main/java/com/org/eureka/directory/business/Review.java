package com.org.eureka.directory.business;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.io.ObjectInputFilter;
import java.lang.annotation.Inherited;
import java.sql.Time;
import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Document(collection = "review")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Review {

	@Id
	private ObjectId id;

	private String comment;

	private Boolean recommend;

	private LocalDateTime created;
	private LocalDateTime updated;


	public Review( String comment,Boolean recommend, LocalDateTime created, LocalDateTime updated) {
		this.comment = comment;
		this.recommend= recommend;
		this.created = created;
		this.updated = updated;
	}
}
