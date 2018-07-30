package com.tejyasols.surveyApp.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.tejyasols.surveyApp.domain.Answer;
import com.tejyasols.surveyApp.domain.Category;
import com.tejyasols.surveyApp.domain.Questionnaire;
import com.tejyasols.surveyApp.domain.QuestionsWrapper;
import com.tejyasols.surveyApp.service.AnswerService;
import com.tejyasols.surveyApp.service.CategoryService;
import com.tejyasols.surveyApp.service.QuestionService;
import com.tejyasols.surveyApp.service.SurveyResultsService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
public static final Logger logger = LoggerFactory.getLogger(AdminController.class);

	@Autowired
	CategoryService categoryService;
	
	
	@Autowired
	QuestionService questionService; 
	
	@Autowired
	AnswerService answerService;
	
	@Autowired
	SurveyResultsService surveyResultsService;


	@GetMapping("/home")
	public ModelAndView index() {
		List<Category> catList = new ArrayList<Category>();
		try {
			catList = categoryService.findAll();
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return new ModelAndView("home");
	}
	
	@GetMapping("/admin")
	public ModelAndView admin() {
		return new ModelAndView("admin");
	}

	@RequestMapping("/createCategoryForm")
	public ModelAndView createCategoryForm() {
		return new ModelAndView("createCategoryForm","command",new Category());
	}
	

	/*@GetMapping("/getAllCategories")
	public List<Category> getAllCategories() {
		List<Category> categoriesList = new ArrayList<Category>();
		try {
			categoriesList = categoryService.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return categoriesList;
	}*/
	
	@GetMapping("/getAllCategories")
	public ModelAndView getAllCategories(@ModelAttribute("Category") Category category,BindingResult result) {
		List<Category> categoriesList = new ArrayList<Category>();
		try {
			categoriesList = categoryService.findAll();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ModelAndView mv = new ModelAndView("createQuestionnaireForm");
		mv.addObject("categoriesList", categoriesList);
		return mv;
	}
	
	@GetMapping("/getCategory/{id}")
	public ModelAndView getCategoryById(@ModelAttribute("Category") Category category ,@PathVariable Long id) {
		Category categoryFound = new Category();
		try {
			categoryFound = categoryService.findById(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ModelAndView("categoryEditForm", "categoryFound", categoryFound) ;
	}
	
	@GetMapping("/getAllCategoriesInJsp")
	public ModelAndView getAllCategoriesInJsp(@ModelAttribute("Category") Category category) {
		List<Category> categoriesList = new ArrayList<Category>();
		try {
			categoriesList = categoryService.findAll();
			logger.debug("size of list is "+categoriesList.size());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ModelAndView("categoriesList", "Categories", categoriesList) ;
	}
	
	/*@PostMapping("/createCategory")
	public ModelAndView createNote(Category category) {
		
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		List<Category> categoriesList = new ArrayList<Category>();
		category.setCreateDateTime(timestamp);
		category.setUpdateDateTime(timestamp);
		try {
			categoryService.createCategory(category);
			categoriesList = categoryService.findAll();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.debug("new category saved and latest list is as follows");
		categoriesList.stream().forEachOrdered(s->logger.debug(String.valueOf(s.getCategoryId())));
		return new ModelAndView("categoriesList", "Categories", categoriesList) ;
	}*/
	
	@PostMapping("/createCategory")
	public ModelAndView createNote(Category category) {
		
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		List<Category> categoriesList = new ArrayList<Category>();
		category.setCreateDateTime(timestamp);
		category.setUpdateDateTime(timestamp);
		try {
			categoryService.createCategory(category);
			categoriesList = categoryService.findAll();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.debug("new category saved and latest list is as follows");
		categoriesList.stream().forEachOrdered(s->logger.debug(String.valueOf(s.getCategoryId())));
		return new ModelAndView("categoriesList", "Categories", categoriesList) ;
	}

	/*@PostMapping("/createCategory")
	public Category createNote(@RequestBody Category category) {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		List<Category> categoriesList = new ArrayList<Category>();
		category.setCreateDateTime(timestamp);
		category.setUpdateDateTime(timestamp);
		Category categorySaved = new Category();
		try {
			categorySaved = categoryService.createCategory(category);
			categoriesList = categoryService.findAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		logger.debug("new category saved and latest list is as follows");
		categoriesList.stream().forEachOrdered(s->logger.debug(String.valueOf(s.getId())));
		return categorySaved;
	}*/
	
	@PostMapping("/updateCategoryById")
	public ModelAndView updateCategoryById(@Valid @ModelAttribute("Category")Category category,@AuthenticationPrincipal final UserDetails userDetails) {
		String un = userDetails.getUsername();
		Collection<? extends GrantedAuthority> authorities = userDetails.getAuthorities();
		authorities.stream().forEach(a->logger.debug(""+a));
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		logger.debug("recieced updateCategoryById api call");
		Category categoryUpdate = new Category();
		
		try {
			logger.debug("categoryId is "+category.getCategoryId());
			logger.debug("updated to "+category.getCategoryName());
			category.setUpdateDateTime(timestamp);
			categoryUpdate = categoryService.updateCategoryById(category);
			List<Category> categoriesList = categoryService.findAll();
			return new ModelAndView("categoriesList", "Categories", categoriesList) ;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ModelAndView("error");
		}
		
	}
	
	@PostMapping("/updateQuestionById")
	public ModelAndView updateQuestionById(@Valid @ModelAttribute("Question")Questionnaire questionnaire) {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		logger.debug("recieced updateCategoryById api call");
		Questionnaire questionnaireUpdate = new Questionnaire();
		
		try {
			logger.debug("questionId is "+questionnaire.getQuestionId());
			logger.debug("updated to "+questionnaire.getQuestion());
			questionnaire.setUpdateDateTime(timestamp);
			questionnaireUpdate = questionService.updateQuestionById(questionnaire);
			List<Questionnaire> questionsList = questionService.findall();
			return new ModelAndView("listCategoryWiseQuestions", "questionList", questionsList) ;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new ModelAndView("error");
		}
		
	}

	/*@PostMapping("/updateCategoryById")
	public Category updateCategoryById(@Valid @RequestBody Category category) {
		Category categoryUpdate = new Category();
		try {
			categoryUpdate = categoryService.updateCategoryById(category);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return categoryUpdate;
	}*/
	
	@RequestMapping("/deleteCategoryById/{id}")
	public ModelAndView deleteCategoryById(@Valid @PathVariable Long id) {
		logger.debug("recieced deleteCategoryById api call");
		try {
			categoryService.deleteCategory(id);
			List<Category> categoriesList = categoryService.findAll();
			return new ModelAndView("categoriesList", "Categories", categoriesList) ;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return  new ModelAndView("error");
		}
	    
	}
	
	@RequestMapping("/deleteQuestionById/{id}")
	public ModelAndView deleteQuestionById(@Valid @PathVariable Long id) {
		logger.debug("recieced deleteCategoryById api call");
		
		try {
			Boolean flag = questionService.deleteQuestionById(id);
			if(flag==true)
			{
			
			return new ModelAndView("success") ;
			}
			else
			{
				return new ModelAndView("error") ;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return  new ModelAndView("error");
		}
	    
	}
	
	@GetMapping("/addOrEditQuestionsByCategoryId/{id}")
	public ModelAndView addOrEditQuestionsByCategoryId(@ModelAttribute("Category") Category category, @PathVariable Long id) {
		logger.debug("recieced addOrEditQuestionsByCategoryId api call");
		try {
			List<Questionnaire> questionsFound = questionService.findByCategoryId(id);
			logger.debug("found questions of number"+questionsFound.size());
			ModelAndView mav = new ModelAndView();
			Category categoryFound = categoryService.findById(id);
			if(questionsFound.size()>0)
			{
				mav.setViewName("listCategoryWiseQuestions");
				mav.addObject("categoryFound", categoryFound);
				mav.addObject("questionList", questionsFound);
				return mav;
			}
			else
			{
				mav.setViewName("createQuestionnaireForm");
				logger.debug("categoryFound for "+categoryFound);
				mav.addObject("categoryFound", categoryFound);
				return mav;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return  new ModelAndView("success");
		}
	    
	}
	
	@PostMapping("/createQuestions")
	public ModelAndView createQuestions(@ModelAttribute("Category") Category category) throws Exception {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		for(Questionnaire ques : category.getQuestions())
		{
			Questionnaire questionnaire = new Questionnaire();
			questionnaire.setQuestion(ques.getQuestion());
			questionnaire.setCategory(category);
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
			List<Answer> savedAnswerList = answerService.createAnswer(answerList);
		}
		logger.info("Form submitted successfully.");
		return  new ModelAndView("success");
	}
	
	@GetMapping("/listQuestionsForSurvey/{categoryId}")
	public ModelAndView listQuestionsForSurvey(@PathVariable Long categoryId) throws Exception
	{
		QuestionsWrapper qlw = new QuestionsWrapper();
//		qlw.setQuestions(questionService.findQuestionsForSurvey(categoryId));;
		ModelAndView mav = new ModelAndView();
		mav.setViewName("takeSurvey");
		mav.addObject("questionsListWrapper", qlw);
		return mav;
	}
	
	
	@PostMapping("/saveSurvey")
	public ModelAndView saveSurvey(@ModelAttribute("questionsListWrapper") QuestionsWrapper qw) throws Exception
	{
		logger.debug("called saveSurvey");
		qw.getQuestions().forEach(q->{
			logger.debug("qid is "+q.getQuestionId());
			logger.debug("each question answered "+q.getQuestion());
			logger.debug("it answer is" +q.getAnswer());
			try {
				surveyResultsService.saveSurvey(qw);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		return  new ModelAndView("success");
	}
/*	@PostMapping("/createQuestionnaire")
	public @Valid Questionnaire createNote(@Valid @RequestBody Questionnaire question) {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		question.setCreateDateTime(timestamp);
		question.setUpdateDateTime(timestamp);
		return questionnaireRepository.save(question);
	}*/
}
