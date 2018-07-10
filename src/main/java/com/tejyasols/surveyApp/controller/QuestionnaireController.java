package com.tejyasols.surveyApp.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.tejyasols.surveyApp.domain.Category;
import com.tejyasols.surveyApp.domain.Questionnaire;
import com.tejyasols.surveyApp.service.CategoryService;
import com.tejyasols.surveyApp.service.QuestionService;

@RestController
@RequestMapping("/QuestionnaireController")
public class QuestionnaireController {

	public static final Logger logger = LoggerFactory.getLogger(QuestionnaireController.class);

	@Autowired
	QuestionService questionService;

	@Autowired
	CategoryService categoryService;

	@GetMapping("create-Questionnaire")
	public ModelAndView createQuestionnairesView() {
		
		ModelAndView mav = new ModelAndView();
		List<Category> categoriesList = new ArrayList<Category>();
		List<String> quesList = new ArrayList<String>();
		
		
		try {
			
			mav.setViewName("createQuestionnaire");
			mav.addObject("category", new Category());
			categoriesList = categoryService.findAll();
			System.out.println(mav.getViewName());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		categoriesList.stream().forEachOrdered(s -> logger.debug(String.valueOf(s.getCategoryId())));
		mav.addObject("quesList", quesList);
		mav.addObject("allCategories", categoriesList);
		return mav;
	}

	@PostMapping("/createQuestions")
	public ModelAndView createQuestion(@Valid Category category, BindingResult result) throws Exception {
		logger.debug("reached form");
		ModelAndView mav = new ModelAndView();
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		if (result.hasErrors()) {
			logger.debug("errors found are "+result.getAllErrors());
		}
		logger.debug("chose category is "+category.getCategoryId().getClass());
		category.getQuestions().stream().forEachOrdered(q->logger.debug("question is "+q.getQuestion())); 
		category.getQuestions().stream().forEachOrdered(c->c.setCategoryId(category.getCategoryId()));
		category.getQuestions().stream().forEachOrdered(c->c.setCreateDateTime(timestamp));
		category.getQuestions().stream().forEachOrdered(c->c.setUpdateDateTime(timestamp));
		category.getQuestions().stream().forEachOrdered(c->logger.debug("setting category.id for each question "+c.getCategoryId().getClass()));
		logger.debug("cat is "+category.toString());
		List<Questionnaire> questionsAdded = questionService.saveall(category.getQuestions());
		logger.debug("no of questions added is "+questionsAdded.size());
		logger.info("Form submitted successfully.");
		return null;
	}

	
	/* * @PostMapping("/createQuestionnaire") public Questionnaire
	 * createQuestion(@Valid @RequestBody String questionsList) { Timestamp
	 * timestamp = new Timestamp(System.currentTimeMillis());
	 * 
	 * try { List<Questionnaire> reqList = new ArrayList<Questionnaire>();
	 * Questionnaire q1 = new Questionnaire(); Questionnaire q2 = new
	 * Questionnaire(); Category cat1 = new Category(); Category cat2 = new
	 * Category(); cat1.setId(new Long(8)); cat2.setId(new Long(8));
	 * q1.setQuestion("Do you Like Cricket"); q1.setCategory(cat1);
	 * q1.setCreateDateTime(timestamp); q1.setUpdateDateTime(timestamp);
	 * q2.setQuestion("Do you Like Tennis"); q2.setCategory(cat2);
	 * q2.setCreateDateTime(timestamp); q2.setUpdateDateTime(timestamp);
	 * reqList.add(q1); reqList.add(q2);
	 * 
	 * List<Questionnaire> lt = questionService.saveall(reqList);
	 * lt.stream().forEachOrdered(l->logger.debug(l.getId().toString())); return
	 * null; } catch (Exception e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); return null; } }*/
	 

}
