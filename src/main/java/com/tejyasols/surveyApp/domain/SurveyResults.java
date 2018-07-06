package com.tejyasols.surveyApp.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "SurveyResults")
@EntityListeners(AuditingEntityListener.class)
public class SurveyResults implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2568845337296151487L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "survey_results_id")
	private Long id;

	@ManyToOne(targetEntity = UserDetails.class)
	@Cascade(value = org.hibernate.annotations.CascadeType.SAVE_UPDATE)
	private UserDetails userid;

	@ManyToOne(targetEntity = Questionnaire.class)
	@Cascade(value = org.hibernate.annotations.CascadeType.SAVE_UPDATE)
	private Questionnaire questionnaire;

	@Column
	private String answer;

	private ResultMetric resultMetric;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UserDetails getUserid() {
		return userid;
	}

	public void setUserid(UserDetails userid) {
		this.userid = userid;
	}

	public Questionnaire getQuestionnaire() {
		return questionnaire;
	}

	public void setQuestionnaire(Questionnaire questionnaire) {
		this.questionnaire = questionnaire;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public ResultMetric getResultMetric() {
		return resultMetric;
	}

	public void setResultMetric(ResultMetric resultMetric) {
		this.resultMetric = resultMetric;
	}

}
