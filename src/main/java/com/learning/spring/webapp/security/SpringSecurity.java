package com.learning.spring.webapp.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.learning.spring.webapp.service.SecurityCustomUserDetailService;

@Configuration
public class SpringSecurity {
	
	private final SecurityCustomUserDetailService userDetailService;

	public SpringSecurity(SecurityCustomUserDetailService userDetailService) {
		this.userDetailService = userDetailService;
	}
	
	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider daoAuthProvider = new DaoAuthenticationProvider();
		daoAuthProvider.setUserDetailsService(userDetailService);
		daoAuthProvider.setPasswordEncoder(passwordEncoder());
		return daoAuthProvider;
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
