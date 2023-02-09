package com.microservices.service;

import java.util.List;

import com.microservices.model.User;

public interface UserService {
	
	User addUser(User user);
	
	List<User> getAllUser();
	
	User getUser(int userId);

}
