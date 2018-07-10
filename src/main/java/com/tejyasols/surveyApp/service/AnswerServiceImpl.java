package com.tejyasols.surveyApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tejyasols.surveyApp.domain.Answer;
import com.tejyasols.surveyApp.repository.AnswerRepository;

@Service
public class AnswerServiceImpl implements AnswerService {
	
	@Autowired
	AnswerRepository answerRepositry;

	@Override
	public List<Answer> createAnswer(List<Answer> answerList) throws Exception {
		// TODO Auto-generated method stub
		return answerRepositry.saveAll(answerList);
	}

}
