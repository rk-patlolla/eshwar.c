package com.tejyasols.surveyApp.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.tejyasols.surveyApp.domain.Category;
import com.tejyasols.surveyApp.domain.Questionnaire;
import com.tejyasols.surveyApp.repository.QuestionnaireRepository;
import com.tejyasols.surveyApp.service.CategoryService;

@RestController
@RequestMapping("/CategoryController")
public class CategoryController {
	
public static final Logger logger = LoggerFactory.getLogger(CategoryController.class);

	@Autowired
	CategoryService categoryService;
	
	@Autowired
	QuestionnaireRepository questionnaireRepository;


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
	public ModelAndView getAllCategoriesInJsp() {
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
		categoriesList.stream().forEachOrdered(s->logger.debug(String.valueOf(s.getId())));
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
	public ModelAndView updateCategoryById(@Valid Category category) {
		logger.debug("recieced updateCategoryById api call");
		Category categoryUpdate = new Category();
		
		try {
			
			categoryUpdate = categoryService.updateCategoryById(category);
			List<Category> categoriesList = categoryService.findAll();
			return new ModelAndView("categoriesList", "Categories", categoriesList) ;
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
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return  new ModelAndView("success");
	}
	
	@PostMapping("/createQuestionnaire")
	public @Valid Questionnaire createNote(@Valid @RequestBody Questionnaire question) {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		question.setCreateDateTime(timestamp);
		question.setUpdateDateTime(timestamp);
		return questionnaireRepository.save(question);
	}
}
