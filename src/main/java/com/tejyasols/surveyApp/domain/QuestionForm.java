package com.tejyasols.surveyApp.domain;

import java.util.List;

public class QuestionForm {
	
	public Long id;
	public List<Questionnaire> questions;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public List<Questionnaire> getQuestions() {
		return questions;
	}
	public void setQuestions(List<Questionnaire> questions) {
		this.questions = questions;
	}
	@Override
	public String toString() {
		return "QuestionForm [id=" + id + ", questions=" + questions + "]";
	}
	
	

}
