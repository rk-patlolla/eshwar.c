package com.tejyasols.surveyApp.service;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tejyasols.surveyApp.domain.Category;
import com.tejyasols.surveyApp.repository.CategoryRepository;
import com.tejyasols.surveyApp.utils.ResourceNotFoundException;

@Service
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	CategoryRepository categoryRepository;

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

	@Override
	public Category updateCategoryById(Category category) throws Exception {
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		Category categoryUpdate = categoryRepository.findById(category.getId()).orElseThrow(() -> new ResourceNotFoundException("Category", "id", category.getId()));
		categoryUpdate.setCategoryName(category.getCategoryName());
		categoryUpdate.setUpdateDateTime(timestamp);
	    return categoryRepository.save(categoryUpdate);
	    
	}

	@Override
	public void deleteCategory(Long id) throws Exception {
		Category categoryUpdate = categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Category", "id", id));
		categoryRepository.delete(categoryUpdate);
		
		
	}

	@Override
	public Category findById(Long id) throws Exception {
		Category categoryFound = categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Category", "id", id));
		return categoryFound;
	}

	

	
}
