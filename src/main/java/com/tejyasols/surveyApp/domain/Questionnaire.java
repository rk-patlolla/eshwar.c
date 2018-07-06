package com.tejyasols.surveyApp.domain;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "Questionnaire")
@EntityListeners(AuditingEntityListener.class)
public class Questionnaire implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 630642182724268139L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "question_id")
	private Long id;

	@Column
	@NotBlank
	private String question;

	@ManyToOne(targetEntity = Category.class)
	@Cascade(value = org.hibernate.annotations.CascadeType.SAVE_UPDATE)
	private Category category;

	@Column(name = "created_date", nullable = false, updatable = false)
	private Timestamp createDateTime;

	@Column(name = "modified_date",nullable = false, updatable = true)
	private Timestamp updateDateTime;

	@Column
	private boolean isActive = false;

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
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
