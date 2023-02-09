package com.microservices.service;

import java.util.List;

import com.microservices.model.Rating;

public interface RatingService {
	
	Rating addRating(Rating rating);
	
	List<Rating> getAllRatings();
	
	List<Rating> getAllRatingsByUser(int userId);
	
	List<Rating> getAllRatingsByHotel(int hotelId);

}
