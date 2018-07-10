package com.tejyasols.surveyApp.domain;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
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
	@SequenceGenerator(name = "seq_contacts", sequenceName = "seq_contacts")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_contacts")
	@Column(name = "questionId")
	private Long questionId;

	@Column
	@NotBlank
	private String question;

	@ManyToOne(targetEntity = Category.class)
	@Cascade(value = org.hibernate.annotations.CascadeType.SAVE_UPDATE)
	private Long categoryId;

	@Column(name = "created_date", nullable = false, updatable = false)
	private Timestamp createDateTime;

	@Column(name = "modified_date", nullable = false, updatable = true)
	private Timestamp updateDateTime;

	@Column
	private boolean isActive = false;

	@ManyToOne
	@JoinColumn(name = "categoryId")
	public Category category;
	
	@Transient
	public List<Answer> answers;

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public Long getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Long questionId) {
		this.questionId = questionId;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
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

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	@Override
	public String toString() {
		return "Questionnaire [questionId=" + questionId + ", question=" + question + ", categoryId=" + categoryId
				+ ", createDateTime=" + createDateTime + ", updateDateTime=" + updateDateTime + ", isActive=" + isActive
				+ ", category=" + category + "]";
	}

	

}
