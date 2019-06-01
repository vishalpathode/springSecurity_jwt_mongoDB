package com.jwt.mongodb.JwtspringSecurityMongoDB.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import com.jwt.mongodb.JwtspringSecurityMongoDB.model.User;

public class USerDAOImpl implements UserDAO{

	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Override
	public List<User> getAllUsers() {
		return mongoTemplate.findAll(User.class);
	}

	@Override
	public User getUserById(String id) {
		Query query = new Query();
		query.addCriteria(Criteria.where("id").is(id));
		return mongoTemplate.findOne(query, User.class);
	}
	
	@Override
	public User save(User user) {
		mongoTemplate.save(user);
		return user;
	}

	@Override
	public User findByEmail(String email) {
		Query query = new Query();
		query.addCriteria(Criteria.where("email").is(email));
		return mongoTemplate.findOne(query, User.class);
	}

}
