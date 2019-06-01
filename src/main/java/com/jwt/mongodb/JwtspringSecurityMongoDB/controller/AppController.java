package com.jwt.mongodb.JwtspringSecurityMongoDB.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.jwt.mongodb.JwtspringSecurityMongoDB.model.User;
import com.jwt.mongodb.JwtspringSecurityMongoDB.repository.UserDAO;

@RestController
public class AppController {
	
	@Autowired
	//private UserRepository repository;
	@Qualifier("AppController")
	private UserDAO userDAO;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<User> getAllEmployee() {
	  return userDAO.getAllUsers();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public User getEmployeeById(@PathVariable("id") String id) {
		User e = new User();
		e = userDAO.getUserById(id);
		System.out.println("ID: "+ e.getId());
	  return e;
	}
}
