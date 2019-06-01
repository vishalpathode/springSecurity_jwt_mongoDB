package com.jwt.mongodb.JwtspringSecurityMongoDB.service;

import java.util.List;

import com.jwt.mongodb.JwtspringSecurityMongoDB.model.User;


public interface UserService {

	User save(User user);

	List<User> getAllUsers();

	User getUserByEmail(String email);
	
	User getUserById(String id);

}
