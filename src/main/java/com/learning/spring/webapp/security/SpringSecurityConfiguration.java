package com.learning.spring.webapp.security;

import java.beans.Customizer;

import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfiguration {
	//can use LDAP or db
	// here InMemory
	
//	InMemoryConfiguration
//	InMemoryConfiguration(UserDetails...details)
	
	@Bean
	public InMemoryUserDetailsManager detailsManager() {
		
		UserDetails userDetails1 = createNewUser("Hardik", "admin");
		UserDetails userDetails2 = createNewUser("Chintan", "dummy");
		
		//InMemoryUserDetailsManager(UserDetails...details) variable arguments .. so can pass as many user as want
		return new InMemoryUserDetailsManager(userDetails1 , userDetails2);
	}

	private UserDetails createNewUser(String username, String password) {
		
		Function<String, String> passwordEncoder = input -> passwordEncoder().encode(input);
		UserDetails userDetails = User.builder().passwordEncoder(passwordEncoder)
									.username(username)
									.password(password)
									.roles("USER" , "ADMIN")
									.build();
		return userDetails;
	}
	
	@Bean 
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(
		auth -> auth.anyRequest ().authenticated());
		http.formLogin();
		http.csrf().disable();
		http.headers().frameOptions().disable();
		return http.build();
	}
}
