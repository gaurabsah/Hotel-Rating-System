package com.microservices.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "ratingTbl")
public class Rating {

	@Id
	private String ratingId;

	private int userId;

	private int hotelId;

	private int rating;

	private String feedback;

}
