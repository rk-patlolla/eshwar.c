package com.tejyasols.surveyApp.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.tejyasols.surveyApp.domain.Category;
import com.tejyasols.surveyApp.domain.QuestionsWrapper;
import com.tejyasols.surveyApp.domain.SurveyResults;
import com.tejyasols.surveyApp.domain.UserInfo;
import com.tejyasols.surveyApp.service.CategoryService;
import com.tejyasols.surveyApp.service.QuestionService;
import com.tejyasols.surveyApp.service.SurveyResultsService;
import com.tejyasols.surveyApp.service.UserInfoService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	public static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	UserInfoService userInfoService;
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	QuestionService questionService; 
	
	@Autowired
	SurveyResultsService surveyResultsService;
	
	@Autowired
	BCryptPasswordEncoder bcryptPassworsEncoder;
	
	@RequestMapping("/userCreationForm")
	public ModelAndView userCreationForm()
	{
		return new ModelAndView("addUser","command",new UserInfo());
	}
	
	@PostMapping("/addUser")
	public ModelAndView addUser(UserInfo userInfo)
	{
		userInfo.setUserRole("USER");
		userInfo.setPassword(bcryptPassworsEncoder.encode(userInfo.getPassword()));
		UserInfo userAdded = userInfoService.addUser(userInfo);
		logger.debug("user created with id "+userAdded.getId());
		return new ModelAndView("success");
	}
	
	
	
	@GetMapping("/getAllCategories")
	public ModelAndView getAllCategories(@ModelAttribute("Category") Category category,BindingResult result) {
		List<Category> categoriesList = new ArrayList<Category>();
		try {
			categoriesList = categoryService.findAll();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ModelAndView mv = new ModelAndView("getAllCategoriesForSurvey");
		mv.addObject("Categories", categoriesList);
		return mv;
	}

	@RequestMapping("/selectCategoryForSurvey/{categoryId}")
	public ModelAndView listQuestionsForSurvey(@ModelAttribute("Category") Category category,@PathVariable Long categoryId) throws Exception
	{
		logger.debug("entered selectCategoryForSurvey");
		QuestionsWrapper qlw = new QuestionsWrapper();
		qlw.setQuestions(questionService.findQuestionsForSurvey(categoryId));
		ModelAndView mav = new ModelAndView();
		mav.setViewName("takeSurvey");
		mav.addObject("questionsListWrapper", qlw);
		return mav;
	}
	
	
	@PostMapping("/saveSurvey")
	public ModelAndView saveSurvey(@ModelAttribute("questionsListWrapper") QuestionsWrapper qw) throws Exception
	{
		logger.debug("called saveSurvey");
		List<SurveyResults> survey = new ArrayList<SurveyResults>();
		qw.getQuestions().forEach(q->{
			/*SurveyResults sr = new SurveyResults();
			UserInfo ud = new UserInfo();
			ud.setId(new Long(1));
			sr.setQuestionnaire(q);
			sr.setAnswer(q.getAnswer());
			sr.setUserDetails(ud);
			survey.add(sr);*/
			logger.debug("each question answered "+q.getQuestion());
			logger.debug("it answer is" +q.getAnswer());
		});
		surveyResultsService.saveSurvey(qw);
		return new ModelAndView("success");
	}
	
}