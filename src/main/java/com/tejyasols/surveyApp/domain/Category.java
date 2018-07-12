package com.tejyasols.surveyApp.domain;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "Category")
@EntityListeners(AuditingEntityListener.class)
public class Category implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7626275836587449141L;

	@NotBlank
	private String categoryName;

	@Column(name = "created_date", nullable = false, updatable = false)
	private Timestamp createDateTime;

	 @Id
	 @SequenceGenerator(name = "seq_contacts", sequenceName = "seq_contacts")
	 @GeneratedValue(strategy = GenerationType.AUTO, generator = "seq_contacts")
	private Long categoryId;

	@Column
	private boolean isActive = false;

	@Column(name = "modified_date",nullable = false, updatable = true)
	private Timestamp updateDateTime;
	
	@Transient
	@OneToMany(mappedBy="category")
	private List<Questionnaire> questions;
	

	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Category(Long categoryId, @NotBlank String categoryName) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public Timestamp getCreateDateTime() {
		return createDateTime;
	}

	
	public Timestamp getUpdateDateTime() {
		return updateDateTime;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public void setCreateDateTime(Timestamp createDateTime) {
		this.createDateTime = createDateTime;
	}

	

	public void setUpdateDateTime(Timestamp updateDateTime) {
		this.updateDateTime = updateDateTime;
	}
	
	
	public void merge(Category other) {  
        setCategoryName(other.getCategoryName());  
   }

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}


	public List<Questionnaire> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Questionnaire> questions) {
		this.questions = questions;
	}

	@Override
	public String toString() {
		return "Category [categoryName=" + categoryName + ", createDateTime=" + createDateTime + ", categoryId="
				+ categoryId + ", isActive=" + isActive + ", updateDateTime=" + updateDateTime + ", questions="
				+ questions + "]";
	}

	
	
	
	

	

	

	

}
