package com.tejyasols.surveyApp.service;

import java.util.List;

import com.tejyasols.surveyApp.domain.SurveyResults;

public interface SurveyResultsService {
	
	public List<SurveyResults> saveSurvey(List<SurveyResults> surveyResults) throws Exception;

}
