package com.tejyasols.surveyApp.domain;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "answer")
public class Answer {

	@Id
	@SequenceGenerator(name = "seq_contacts", sequenceName = "seq_contacts")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_contacts")
	private Long Answer_ID;

	@Column
	private String Answer;

	@ManyToOne
	@JoinColumn(name = "questionId")
	private Questionnaire question;

	@Column(name = "created_date", nullable = false, updatable = false)
	private Timestamp createDateTime;

	@Column(name = "modified_date", nullable = false, updatable = true)
	private Timestamp updateDateTime;

	public Answer() {

	}

	public Answer(Long Answer_ID, String Answer, Questionnaire question) {
		super();
		this.Answer_ID = Answer_ID;
		this.Answer = Answer;
		this.question = question;
	}

	public Long getAnswer_ID() {
		return Answer_ID;
	}

	public void setAnswer_ID(Long answer_ID) {
		Answer_ID = answer_ID;
	}

	public String getAnswer() {
		return Answer;
	}

	public void setAnswer(String answer) {
		Answer = answer;
	}

	public Questionnaire getQuestion() {
		return question;
	}

	public void setQuestion(Questionnaire question) {
		this.question = question;
	}

	public Timestamp getCreateDateTime() {
		return createDateTime;
	}

	public void setCreateDateTime(Timestamp createDateTime) {
		this.createDateTime = createDateTime;
	}

	public Timestamp getUpdateDateTime() {
		return updateDateTime;
	}

	public void setUpdateDateTime(Timestamp updateDateTime) {
		this.updateDateTime = updateDateTime;
	}

	
	
}
