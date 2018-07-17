package com.tejyasols.surveyApp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import com.tejyasols.surveyApp.interceptors.AdminInterceptor;
import com.tejyasols.surveyApp.interceptors.LogInterceptor;

//@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {
	
	@Autowired
	LogInterceptor loginInterceptor;
	
	@Autowired
	AdminInterceptor adminInterceptor;
	
	@Override
	   public void addInterceptors(InterceptorRegistry registry) {
	      // LogInterceptor apply to all URLs.
	      registry.addInterceptor(loginInterceptor);
	 
	      // This interceptor apply to URL like /admin/*
	      // Exclude /admin/oldLogin
	      registry.addInterceptor(adminInterceptor);//
	           
	   }

}
