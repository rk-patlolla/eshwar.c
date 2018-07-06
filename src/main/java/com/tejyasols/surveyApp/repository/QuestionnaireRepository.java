package com.tejyasols.surveyApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tejyasols.surveyApp.domain.Questionnaire;

public interface QuestionnaireRepository extends JpaRepository<Questionnaire, Long> {
	
	//public Category 

}
