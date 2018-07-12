package com.tejyasols.surveyApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tejyasols.surveyApp.domain.SurveyResults;
import com.tejyasols.surveyApp.repository.SurveyResultsRepository;

@Service
public class SurveyResultsServiceImpl implements SurveyResultsService {
	
	@Autowired
	SurveyResultsRepository surveyResultsRepository;

	@Override
	public List<SurveyResults> saveSurvey(List<SurveyResults> surveyResults) throws Exception {
		// TODO Auto-generated method stub
		return surveyResultsRepository.saveAll(surveyResults);
	}

}
