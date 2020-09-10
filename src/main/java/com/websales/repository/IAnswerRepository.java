package com.websales.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.websales.entity.AwserDetail;

public interface IAnswerRepository extends JpaRepository<AwserDetail, String> {

	@Override
	public AwserDetail save(AwserDetail entity);
}
