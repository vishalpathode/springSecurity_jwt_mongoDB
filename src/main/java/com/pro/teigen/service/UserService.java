package com.pro.teigen.service;


import com.pro.teigen.model.User;

import java.util.List;

public interface UserService {

	User save(User user);

	List<User> findAll();

	User getUserByEmail(String email);

}
