package com.pro.teigen.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordUtil {

	static BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	
	public static String getPasswordHash(String password) {

		 return encoder.encode(password);
	}

}
