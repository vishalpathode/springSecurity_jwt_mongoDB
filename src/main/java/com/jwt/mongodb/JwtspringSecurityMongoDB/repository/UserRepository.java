package com.jwt.mongodb.JwtspringSecurityMongoDB.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.jwt.mongodb.JwtspringSecurityMongoDB.model.User;

public interface UserRepository extends MongoRepository<User, String> {

}
