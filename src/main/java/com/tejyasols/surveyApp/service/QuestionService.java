package com.tejyasols.surveyApp.service;

import java.util.List;

import javax.validation.Valid;

import com.tejyasols.surveyApp.domain.Answer;
import com.tejyasols.surveyApp.domain.Questionnaire;

public interface QuestionService {
	
	public Questionnaire createQuestion(Questionnaire question) throws Exception;
	
	public Boolean deleteQuestionById(Long id) throws Exception;
	
	public Questionnaire updateQuestionById(Questionnaire questionnaire) throws Exception;

	public List<Questionnaire> saveall(List<Questionnaire> questionsList) throws Exception;
	
	public List<Questionnaire> findall() throws Exception;
	
	public List<Questionnaire> findByCategoryId(Long categoryId) throws Exception;
	
	public List<Questionnaire> findQuestionsForSurvey(Long categoryId) throws Exception;

}
