package com.tejyasols.surveyApp.service;

import java.util.List;

import javax.validation.Valid;

import com.tejyasols.surveyApp.domain.Questionnaire;

public interface QuestionService {
	
	public Questionnaire createQuestion(Questionnaire question) throws Exception;

	public List<Questionnaire> saveall(List<Questionnaire> questionsList);

}
