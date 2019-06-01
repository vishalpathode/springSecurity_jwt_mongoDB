package com.jwt.mongodb.JwtspringSecurityMongoDB.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jwt.mongodb.JwtspringSecurityMongoDB.domain.Response;
import com.jwt.mongodb.JwtspringSecurityMongoDB.model.User;
import com.jwt.mongodb.JwtspringSecurityMongoDB.service.UserService;

@RestController
public class PerLoginController {

	@Autowired
	private UserService userService;
	
	@PostMapping(value = "/registration")
	public ResponseEntity<Response> registration(@RequestBody User user){
		if(user.getFirstname().equals("vishal")) {
			throw new RuntimeException("VISHAL  NOT  ALLOWED.");
		}
		User dbUser = userService.save(user);
		if(dbUser!=null) {
			 return new ResponseEntity<Response>(new Response("User is saved successfully",HttpStatus.INTERNAL_SERVER_ERROR.toString()),HttpStatus.OK);
		}
		return null;
	}
}
