package com.microservices.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.microservices.model.Rating;

@Repository
public interface RatingRepository extends MongoRepository<Rating, String> {

	List<Rating> findByUserId(int userId);

	List<Rating> findByHotelId(int hotelId);

}
