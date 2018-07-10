package com.tejyasols.surveyApp.service;

import java.util.List;

import com.tejyasols.surveyApp.domain.Answer;

public interface AnswerService {
	
	public List<Answer> createAnswer(List<Answer> answerList) throws Exception;

}
