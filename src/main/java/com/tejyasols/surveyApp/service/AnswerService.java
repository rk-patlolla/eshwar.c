package com.tejyasols.surveyApp.service;

import java.util.List;

import com.tejyasols.surveyApp.domain.Answer;
import com.tejyasols.surveyApp.domain.Questionnaire;

public interface AnswerService {
	
	public List<Answer> createAnswer(List<Answer> answerList) throws Exception;

	Boolean deleteAnswersAssosciatedToQuestionsIn(List<Questionnaire> questionsList) throws Exception;

}
