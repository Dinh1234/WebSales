package com.websales.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.websales.entity.QuestionDetail;

public interface IQuestionDetailsRepository extends JpaRepository<QuestionDetail, String> {

	@Override
	public QuestionDetail save(QuestionDetail entity);
}
