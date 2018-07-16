package com.tejyasols.surveyApp.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping("/loginController")
public class LoginController {

	public static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@GetMapping("/home")
	public ModelAndView index() {
		
		return new ModelAndView("home");
	}

	@RequestMapping("/default")
    public ModelAndView defaultAfterLogin(HttpServletRequest request) {
		logger.debug("entered into default");
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String role = auth.getAuthorities().toString();
        role = role.substring(1, role.length()-1);
		logger.debug("found user as "+role);
		
		 
        if (role.equalsIgnoreCase("ADMIN")) {
        	RedirectView redirectView = new RedirectView("/admin/getAllCategoriesInJsp");
            redirectView.setExposePathVariables(false);
            return new ModelAndView(redirectView);
        }
        RedirectView redirectView = new RedirectView("/user/getAllCategories");
        redirectView.setExposePathVariables(false);
        return new ModelAndView(redirectView);
    }

}
