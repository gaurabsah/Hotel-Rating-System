package com.microservices.util;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.microservices.model.Rating;

@FeignClient(name = "RATING-SERVICE")
public interface RatingService {

	@GetMapping("/api/v1/rating/user/{userId}")
	List<Rating> getAllRatingsByUser(@PathVariable int userId);

}
