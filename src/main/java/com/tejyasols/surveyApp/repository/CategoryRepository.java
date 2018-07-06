package com.tejyasols.surveyApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tejyasols.surveyApp.domain.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
