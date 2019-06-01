package com.jwt.mongodb.JwtspringSecurityMongoDB.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.jwt.mongodb.JwtspringSecurityMongoDB.model.User;


@Service
public class JwtUserDetailsServiceImpl implements UserDetailsService{

	//@Autowired	
	//private UserRepository userRepository;
	@Autowired
	@Qualifier("JwtUserDetailsServiceImpl")
	private MongoTemplate mongoTemplate;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Query query = new Query();
		query.addCriteria(Criteria.where("email").is(email));
		User user = mongoTemplate.findOne(query, User.class);
		if(user == null) {
			throw new UsernameNotFoundException(String.format("No user found with username '%s'.", email));
		}else {
			return JwtUserFactory.create(user);
		}
	}
}
