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
import javax.persistence.Table;
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
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
//	@Column(name = "category_id")
	private Long id;

	@Column
	private boolean isActive = false;

	@Column(name = "modified_date",nullable = false, updatable = true)
	private Timestamp updateDateTime;
	
	@OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
	private List<Questionnaire> questions;

	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Category(Long id, @NotBlank String categoryName) {
		super();
		this.id = id;
		this.categoryName = categoryName;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public Timestamp getCreateDateTime() {
		return createDateTime;
	}

	public Long getId() {
		return id;
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

	public void setId(Long id) {
		this.id = id;
	}

	public void setUpdateDateTime(Timestamp updateDateTime) {
		this.updateDateTime = updateDateTime;
	}
	
	
	public void merge(Category other) {  
        setCategoryName(other.getCategoryName());  
   }  
	
	public List<Questionnaire> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Questionnaire> questions) {
		this.questions = questions;
	}

	@Override
	public String toString() {
		return "Category [categoryName=" + categoryName + ", createDateTime=" + createDateTime + ", id=" + id
				+ ", isActive=" + isActive + ", updateDateTime=" + updateDateTime + ", questions=" + questions + "]";
	}

	

	

}
