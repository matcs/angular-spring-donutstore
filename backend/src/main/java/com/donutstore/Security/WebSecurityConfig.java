package com.donutstore.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private UserDetailsImpl userDetails;
	
	@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetails);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		http
			.csrf()
				.disable()
			.cors()
				.disable()
			.authorizeRequests()
				.antMatchers(HttpMethod.GET,"/cliente/login").permitAll() 
				.antMatchers(HttpMethod.GET,"/cliente/**").permitAll()
				.antMatchers(HttpMethod.DELETE,"/donuts/**").hasRole("ADMIN")
				.antMatchers(HttpMethod.PUT,"/donuts/**").hasRole("ADMIN")	 
				.anyRequest().authenticated()
			.and()
				.logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))			
			.and()
		        .httpBasic()
		        .authenticationEntryPoint(new DisablePopUpBrowser());
	}
	
	@Override
	public void configure(WebSecurity security) throws Exception{
		security
			.ignoring()
				.antMatchers(HttpMethod.GET,"/donuts/**")
				.antMatchers(HttpMethod.POST,"/cliente")
				.antMatchers("/compraSave/**");
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() { 
		return new BCryptPasswordEncoder();
	}
	
}
