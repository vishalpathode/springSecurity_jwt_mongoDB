package com.pro.teigen.repository;

import com.pro.teigen.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends MongoRepository<User, String> {

	User findByEmailIgnoreCase(String username);
	
}
