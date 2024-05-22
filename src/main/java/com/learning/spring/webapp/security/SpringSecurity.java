package com.learning.spring.webapp.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SpringSecurity {

	@Bean
	public UserDetailsService userDetailService() {
		UserDetails user1 = User.withUsername("admin123")
							.password(passwordEncoder().encode("admin123"))
							.roles("ADMIN")
							.build();
		
		UserDetails user2 = User.withUsername("admin")
				.password(passwordEncoder().encode("admin"))
				.build();
		
		var inMemoryUserDetailsManager = new InMemoryUserDetailsManager(user1 , user2);
		return inMemoryUserDetailsManager;
	}
	
	@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
