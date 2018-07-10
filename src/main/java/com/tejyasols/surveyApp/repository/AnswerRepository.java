package com.tejyasols.surveyApp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tejyasols.surveyApp.domain.Answer;

public interface AnswerRepository extends JpaRepository<Answer, Long> {

}
