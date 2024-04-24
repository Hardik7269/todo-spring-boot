package com.learning.spring.webapp.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
	public boolean Authenticate(String userName , String password) {
		return userName.equalsIgnoreCase("admin") && password.equalsIgnoreCase("admin");
	}
}
