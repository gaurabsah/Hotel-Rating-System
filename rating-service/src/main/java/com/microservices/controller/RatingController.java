package com.microservices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservices.model.Rating;
import com.microservices.service.RatingService;

@RestController
@RequestMapping("/api/v1/rating")
public class RatingController {

	@Autowired
	private RatingService ratingService;

	@PostMapping
	public ResponseEntity<Rating> createRating(@RequestBody Rating rating) {
		Rating addRating = ratingService.addRating(rating);
		return new ResponseEntity<Rating>(addRating, HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<Rating>> getAllRatings() {
		List<Rating> allRatings = ratingService.getAllRatings();
		return new ResponseEntity<List<Rating>>(allRatings, HttpStatus.OK);
	}

	@GetMapping("/user/{userId}")
	public ResponseEntity<List<Rating>> getAllRatingsByUser(@PathVariable int userId) {
		List<Rating> allRatings = ratingService.getAllRatingsByUser(userId);
		return new ResponseEntity<List<Rating>>(allRatings, HttpStatus.OK);
	}

	@GetMapping("/hotel/{hotelId}")
	public ResponseEntity<List<Rating>> getAllRatingsByHotel(@PathVariable int hotelId) {
		List<Rating> allRatings = ratingService.getAllRatingsByHotel(hotelId);
		return new ResponseEntity<List<Rating>>(allRatings, HttpStatus.OK);
	}

}
