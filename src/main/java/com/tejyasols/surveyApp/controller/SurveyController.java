package com.tejyasols.surveyApp.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.aspectj.weaver.patterns.TypePatternQuestions.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.tejyasols.surveyApp.domain.Answer;
import com.tejyasols.surveyApp.domain.Category;
import com.tejyasols.surveyApp.domain.Questionnaire;
import com.tejyasols.surveyApp.repository.AnswerRepository;
import com.tejyasols.surveyApp.service.CategoryService;
import com.tejyasols.surveyApp.service.QuestionService;

@Controller
@RequestMapping("SurveyController")
public class SurveyController {
	
	public static final Logger logger = LoggerFactory.getLogger(SurveyController.class);
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	AnswerRepository answerRepository;
	
	@Autowired
	QuestionService questionService;
	
	
	@GetMapping("createCategoryForm")
	public ModelAndView createCategory(@Valid Category category,BindingResult result) throws Exception
	{
		ModelAndView mav = new ModelAndView();
		mav.setViewName("createCategory");
		mav.addObject("category", new Category());
		return mav;
		
	}
	
	@PostMapping("/addCategory")
	public ModelAndView createQuestion(@Valid Category category, BindingResult result) throws Exception {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		logger.debug("reached form");
		if (result.hasErrors()) {
			logger.debug("errors found are "+result.getAllErrors());
		}
		logger.debug("new Category is "+category.getCategoryName());
		category.getQuestions().stream().forEachOrdered(q->logger.debug("questions entered: "+q.getQuestion()));
		category.getQuestions().stream().forEachOrdered(q->q.getAnswers().stream().forEach(a->logger.debug("answers added are: "+a.getAnswer())));
		
		Category cat = new Category();
		cat.setCategoryName(category.getCategoryName());
		cat.setCreateDateTime(timestamp);
		cat.setUpdateDateTime(timestamp);
		Category categoryAdded = categoryService.createCategory(cat);
		for(Questionnaire ques : category.getQuestions())
		{
			Questionnaire questionnaire = new Questionnaire();
			questionnaire.setQuestion(ques.toString());
			questionnaire.setCategory(categoryAdded);
			questionnaire.setCreateDateTime(timestamp);
			questionnaire.setUpdateDateTime(timestamp);
			Questionnaire questionAdded = questionService.createQuestion(questionnaire);
			List<Answer> answerList = new ArrayList<Answer>();
			for(Answer ans : ques.getAnswers())
			{
				Answer a = new Answer();
				a.setAnswer(ans.getAnswer());
				a.setQuestion(questionAdded);
				a.setCreateDateTime(timestamp);
				a.setUpdateDateTime(timestamp);
				answerList.add(a);
				
			}
			answerRepository.saveAll(answerList);
		}
		logger.info("Form submitted successfully.");
		return null;
	}
	
	@GetMapping("/viewAllCategories")
	public ModelAndView viewAllCategories() {
		List<Category> categoriesList = new ArrayList<Category>();
		try {
			categoriesList = categoryService.findAll();
			categoriesList.stream().forEach(c->logger.debug(""+c.getCategoryId()));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ModelAndView mv = new ModelAndView("categoryList");
		mv.addObject("categoriesList", categoriesList);
		return mv;
	}
	
	@GetMapping("updateCategoryForm/{categoryId}")
	public ModelAndView updateCategoryForm(@Valid @PathVariable Long categoryId,BindingResult result) throws Exception
	{
		ModelAndView mav = new ModelAndView();
		mav.setViewName("updateCategory");
		mav.addObject("category", new Category());
		Category categoryToBeUpdated = categoryService.findById(categoryId);
		List<Questionnaire> questionList = categoryToBeUpdated.getQuestions();
		mav.addObject("categoryToBeUpdated",categoryToBeUpdated);
		mav.addObject("questionList", questionList);
		return mav;
		
	}
	
	@PostMapping("/updateCategory/{categoryId}")
	public ModelAndView updateCategory(@Valid @PathVariable Long categoryId, BindingResult result)
	{
		logger.debug("request at updateCategory");
		logger.debug("categoryId to be updated is "+categoryId);
		Category categoryUpdate = new Category();
		try {
			categoryUpdate = categoryService.
			List<Category> categoriesList = categoryService.findAll();
			ModelAndView mv = new ModelAndView("categoryList");
			mv.addObject("categoriesList", categoriesList);
			return mv;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

}

	

