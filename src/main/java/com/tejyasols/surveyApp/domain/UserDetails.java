package com.tejyasols.surveyApp.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "UserDetails")
@EntityListeners(AuditingEntityListener.class)
public class UserDetails implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8002839908411696654L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "user_id")
	private Long id;

	@Column
	private String userName;

	@Column
	private String userRole;

	/*@OneToOne
	@PrimaryKeyJoinColumn
	private SurveyResults surveyResults;*/

}
