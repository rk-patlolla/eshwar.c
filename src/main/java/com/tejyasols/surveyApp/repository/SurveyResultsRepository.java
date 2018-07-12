package com.tejyasols.surveyApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.tejyasols.surveyApp.domain.SurveyResults;

@Transactional
@Repository
public interface SurveyResultsRepository extends JpaRepository<SurveyResults, Long> {

}
