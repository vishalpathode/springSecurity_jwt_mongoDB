package com.jwt.mongodb.JwtspringSecurityMongoDB.repository;

import java.util.List;

import com.jwt.mongodb.JwtspringSecurityMongoDB.model.User;

public interface UserDAO {

	User save(User user);
	
	User findByEmail(String email);
	
	List<User> getAllUsers();

	User getUserById(String userId);


}
