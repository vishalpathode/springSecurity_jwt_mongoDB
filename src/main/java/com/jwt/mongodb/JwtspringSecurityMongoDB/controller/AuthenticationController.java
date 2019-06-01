package com.jwt.mongodb.JwtspringSecurityMongoDB.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jwt.mongodb.JwtspringSecurityMongoDB.UnauthorizedException;
import com.jwt.mongodb.JwtspringSecurityMongoDB.domain.UserDTO;
import com.jwt.mongodb.JwtspringSecurityMongoDB.model.User;
import com.jwt.mongodb.JwtspringSecurityMongoDB.security.JwtTokenUtil;
import com.jwt.mongodb.JwtspringSecurityMongoDB.security.JwtUser;


@RestController
public class AuthenticationController {

	@Value("${jwt.header}")
	private String tokenHeader;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@PostMapping(value = "/login")
	public ResponseEntity<UserDTO> login(@RequestBody User user,HttpServletRequest req, HttpServletResponse resp){
		
		try {
			Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword()));
			final JwtUser userDetails =  (JwtUser) authentication.getPrincipal();
			SecurityContextHolder.getContext().setAuthentication(authentication);
			final String token = jwtTokenUtil.generateToken(userDetails);
			resp.setHeader("Token", token);
			return new ResponseEntity<UserDTO>(new UserDTO(userDetails.getUser(), token),HttpStatus.OK);
		}catch(Exception e) {
			throw new UnauthorizedException(e.getMessage());
		}
	}
}
