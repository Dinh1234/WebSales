package com.websales.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.websales.entity.Subject;

public interface ISubjectRepository extends JpaRepository<Subject, String> {

}
