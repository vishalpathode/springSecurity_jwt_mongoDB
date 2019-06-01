package com.jwt.mongodb.JwtspringSecurityMongoDB.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jwt.mongodb.JwtspringSecurityMongoDB.model.User;
import com.jwt.mongodb.JwtspringSecurityMongoDB.repository.UserDAO;
import com.jwt.mongodb.JwtspringSecurityMongoDB.util.PasswordUtil;


@Service
@Transactional
public class UserServiceImpl implements UserService{

	//@Autowired
	//private UserRepository userRepository;
	@Autowired
	private UserDAO userDAO;
	

	@Override
	public User save(User user) {
		String password = PasswordUtil.getPasswordHash(user.getPassword());
		user.setPassword(password);
		user.setCreatedDate(new Date());
		return userDAO.save(user);
	}

	@Override
	public List<User> getAllUsers() {
		List<User> users = userDAO.getAllUsers();
		return users;
	}

	@Override
	public User getUserById(String id) {
		User user = userDAO.getUserById(id);
		return user;
	}

	@Override
	public User getUserByEmail(String email) {
		User user = userDAO.findByEmail(email);
		return user;
	}
}
