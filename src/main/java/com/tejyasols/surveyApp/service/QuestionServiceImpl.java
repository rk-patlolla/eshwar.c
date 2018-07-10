package com.tejyasols.surveyApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tejyasols.surveyApp.domain.Questionnaire;
import com.tejyasols.surveyApp.repository.QuestionnaireRepository;

@Service
public class QuestionServiceImpl implements QuestionService {
	
	@Autowired
	QuestionnaireRepository questionnaireRepository;

	@Override
	public Questionnaire createQuestion(Questionnaire question) throws Exception {
		// TODO Auto-generated method stub
		return questionnaireRepository.save(question);
	}

	@Override
	public List<Questionnaire> saveall(List<Questionnaire> questionsList) throws Exception {
		// TODO Auto-generated method stub
		try
		{
		return questionnaireRepository.saveAll(questionsList);
		}catch(Exception ex)
		{
			ex.printStackTrace();
			return null;
		}
		
	}

}
