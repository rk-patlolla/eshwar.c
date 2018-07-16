package com.tejyasols.surveyApp.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SpringSecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// TODO Auto-generated method stub
		auth.inMemoryAuthentication().withUser("rohtek-admin").password("{noop}adminPass123").roles("ADMIN").and()
				.withUser("rohtek-user").password("{noop}userPass123").roles("USER");
	}

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.authorizeRequests().
		anyRequest().
		fullyAuthenticated().
		antMatchers("*/updateCategoryById").hasRole("ADMIN").
		and().httpBasic();
		httpSecurity.csrf().disable();
	}

}
