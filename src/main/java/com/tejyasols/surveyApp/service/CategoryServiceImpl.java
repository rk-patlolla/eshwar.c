package com.tejyasols.surveyApp.service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tejyasols.surveyApp.domain.Category;
import com.tejyasols.surveyApp.domain.Questionnaire;
import com.tejyasols.surveyApp.repository.CategoryRepository;
import com.tejyasols.surveyApp.utils.ResourceNotFoundException;

@Service
public class CategoryServiceImpl implements CategoryService {
	public static final Logger logger = LoggerFactory.getLogger(CategoryServiceImpl.class);

	@Autowired
	CategoryRepository categoryRepository;

	@Autowired
	QuestionService questionService;

	@Autowired
	AnswerService answerService;

	@Autowired
	EntityManager entityManager;

	@Override
	public Category createCategory(Category category) throws Exception {
		// TODO Auto-generated method stub
		return categoryRepository.save(category);
	}

	@Override
	public List<Category> findAll() throws Exception {
		// TODO Auto-generated method stub
		return categoryRepository.findAll();
	}

	/*
	 * @Override public Category updateCategoryById(Category category) throws
	 * Exception { Timestamp timestamp = new Timestamp(System.currentTimeMillis());
	 * Category categoryUpdate =
	 * categoryRepository.findById(category.getCategoryId()).orElseThrow(() -> new
	 * ResourceNotFoundException("Category", "id", category.getCategoryId()));
	 * categoryUpdate.setCategoryName(category.getCategoryName());
	 * categoryUpdate.setUpdateDateTime(timestamp); return
	 * categoryRepository.save(categoryUpdate);
	 * 
	 * }
	 */

	@Override
	public Category updateCategoryById(Category category) throws Exception {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		Category categoryUpdate = categoryRepository.findById(category.getCategoryId())
				.orElseThrow(() -> new ResourceNotFoundException("Category", "id", category.getCategoryId()));
		categoryUpdate.setCategoryName(category.getCategoryName());
		categoryUpdate.setUpdateDateTime(timestamp);
		return categoryRepository.save(categoryUpdate);

	}

	@Override
	@Transactional
	public void deleteCategory(Long id) throws Exception {
		Optional<Category> categoryUpdate = categoryRepository.findById(id);
		Category categoryFound = new Category();
		if (categoryUpdate.isPresent()) {
			logger.debug("found category" + categoryUpdate.get());
			categoryFound = categoryUpdate.get();
		} else {
			logger.debug("something went wroong while finding categoryUpdate");
		}

		List<Questionnaire> questionsList = questionService.findByCategoryId(categoryUpdate.get().getCategoryId());
		if (questionsList.size() > 0) {
			Boolean answersDeleted = answerService.deleteAnswersAssosciatedToQuestionsIn(questionsList);
			Boolean questionsDeleted = questionService.deleteQuestionsBasedOnCategoryId(categoryFound);
		}
		categoryRepository.deleteById(categoryFound.getCategoryId());

	}

	@Override
	public Category findById(Long id) throws Exception {
		Category categoryFound = categoryRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Category", "id", id));
		return categoryFound;
	}

}
