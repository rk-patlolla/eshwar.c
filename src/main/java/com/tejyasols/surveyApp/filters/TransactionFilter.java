package com.tejyasols.surveyApp.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.*;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
public class TransactionFilter implements Filter {
	
	public static final Logger logger = LoggerFactory.getLogger(TransactionFilter.class);

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
        logger.debug(
          "Starting a transaction for req : {}", 
          req.getRequestURI());
  
        chain.doFilter(request, response);
        logger.debug(
          "Committing a transaction for req : {}", 
          req.getRequestURI());
		
	}
	
	@Bean
	public FilterRegistrationBean transactionFilterBean() {
	  final FilterRegistrationBean transactionFilterBean = new FilterRegistrationBean();
	  transactionFilterBean.setFilter(new TransactionFilter());
	  transactionFilterBean.addUrlPatterns("/*");
	  transactionFilterBean.setEnabled(Boolean.TRUE);
	  transactionFilterBean.setName("Meuw Filter");
	  transactionFilterBean.setAsyncSupported(Boolean.TRUE);
	  return transactionFilterBean;
	}

}
