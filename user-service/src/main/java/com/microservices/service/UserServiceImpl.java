package com.microservices.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservices.exception.ResourceNotFoundException;
import com.microservices.model.User;
import com.microservices.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

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
		return user;
	}

}
