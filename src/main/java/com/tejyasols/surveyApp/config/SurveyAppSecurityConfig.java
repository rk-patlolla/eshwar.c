package com.tejyasols.surveyApp.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.tejyasols.surveyApp.filters.RequestResponseFilter;
import com.tejyasols.surveyApp.service.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
public class SurveyAppSecurityConfig extends WebSecurityConfigurerAdapter {
	
	  @Autowired
	    private UserDetailsServiceImpl userDetailsService;
	 
	    @Autowired
	    private DataSource dataSource;
	    
	    @Autowired
	    RequestResponseFilter requestResponseFilter;

	@Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
 
        // Setting Service to find User in the database.
        // And Setting PassswordEncoder
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
 
    }
	  @Override
	    protected void configure(HttpSecurity http) throws Exception {
		  http.csrf().disable();
		  
	        // The pages does not require login
	        	http.authorizeRequests().antMatchers("admin/**").hasRole("ADMIN").anyRequest().authenticated()
	            .antMatchers("user/**").hasRole("USER").anyRequest().authenticated()
	            .and().addFilterAt(requestResponseFilter,BasicAuthenticationFilter.class);
	            /*.anyRequest().authenticated()*/;
	            
	        	http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403");
	        	 
	            // Config for Login Form
	            http.authorizeRequests().and().formLogin()//
	                    // Submit URL of login page.
	                    .defaultSuccessUrl("/loginController/default")//
	                    .failureUrl("/login?error=true")//
	                    .usernameParameter("username")//
	                    .passwordParameter("password")
	                    // Config for Logout Page
	                    .and().logout().invalidateHttpSession(true);
	     
	            // Config Remember Me.
	            http.authorizeRequests().and() //
	                    .rememberMe().tokenRepository(this.persistentTokenRepository()) //
	                    .tokenValiditySeconds(1 * 24 * 60 * 60); // 24h
	     

	    }

	    @Bean
	    public BCryptPasswordEncoder passwordEncoder() {
	        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
	        return bCryptPasswordEncoder;
	    }
	    
	    @Bean
	    public PersistentTokenRepository persistentTokenRepository() {
	    JdbcTokenRepositoryImpl db = new JdbcTokenRepositoryImpl();
	    db.setDataSource(dataSource);
	    return db;
	    }

}
