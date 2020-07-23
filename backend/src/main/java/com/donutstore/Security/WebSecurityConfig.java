package com.donutstore.Security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

@Configuration
public class WebSecurityConfig {
	public void configure(HttpSecurity http) throws Exception{
		http.authorizeRequests()
			.anyRequest().authenticated()
			.and()
			.httpBasic();
	}
	
	protected void configure(AuthenticationManagerBuilder auth) {
		//auth.inMemoryAuthentication();
			
	}
}
