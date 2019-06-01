package com.jwt.mongodb.JwtspringSecurityMongoDB.domain;

import java.io.Serializable;

import com.jwt.mongodb.JwtspringSecurityMongoDB.model.User;


public class UserDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4986289138397096156L;
	
	private User user;
	private String token;

	public UserDTO(User user, String token) {
		super();
		this.user = user;
		this.token = token;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
	
	
	
}
