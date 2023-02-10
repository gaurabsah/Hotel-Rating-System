package com.microservices.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.microservices.exception.ResourceNotFoundException;
import com.microservices.model.Hotel;
import com.microservices.model.Rating;
import com.microservices.model.User;
import com.microservices.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RestTemplate restTemplate;

	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Override
	public User addUser(User user) {
		User newUser = userRepository.save(user);
		return newUser;
	}

	@Override
	public List<User> getAllUser() {
		List<User> list = userRepository.findAll();
		return list;
	}

	@Override
	public User getUser(int userId) {
		User user = userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User not found!!!"));
//		call api from rating service using Rest template
		List<Rating> list = Arrays.asList(restTemplate
				.getForObject("http://RATING-SERVICE/api/v1/rating/user/" + user.getUserId(), Rating[].class));
		logger.info("Ratings Fetched using User");
		List<Rating> ratingList = list.stream().map(rating -> {
//			api call for hotel
			Hotel hotel = restTemplate.getForObject("http://HOTEL-SERVICE/api/v1/hotel/" + rating.getHotelId(),
					Hotel.class);

//			set hotel to rating
			rating.setHotel(hotel);
//			return rating
			return rating;
		}).collect(Collectors.toList());
		user.setRatings(ratingList);
		return user;
	}

}
