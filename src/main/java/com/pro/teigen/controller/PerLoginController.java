package com.pro.teigen.controller;

import com.pro.teigen.domain.Response;
import com.pro.teigen.model.User;
import com.pro.teigen.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
