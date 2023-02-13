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

import com.microservices.model.User;
import com.microservices.service.UserService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/add")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		User addUser = userService.addUser(user);
		return new ResponseEntity<>(addUser, HttpStatus.CREATED);
	}

	@GetMapping("/{userId}")
//	@CircuitBreaker(name = "ratingHotelBreaker", fallbackMethod = "ratingHotelFallback")
//	@Retry(name = "ratingHotelService", fallbackMethod = "ratingHotelFallback")
	@RateLimiter(name = "userRateLimiter", fallbackMethod = "ratingHotelFallback")
	public ResponseEntity<User> getUser(@PathVariable int userId) {
		User user = userService.getUser(userId);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	public ResponseEntity<User> ratingHotelFallback(String userId, Exception ex) {
		ex.printStackTrace();
		User user = User.builder().email("dummy@user.in").name("dummy").about("Failed!!! TRY AGAIN...").userId(100)
				.build();
		return new ResponseEntity<>(user, HttpStatus.BAD_REQUEST);
	}

	@GetMapping
	public ResponseEntity<List<User>> getAllUsers() {
		List<User> allUser = userService.getAllUser();
		return new ResponseEntity<List<User>>(allUser, HttpStatus.OK);
	}

}
