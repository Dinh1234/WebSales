package com.websales.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.websales.entity.Category;
import com.websales.entity.CategoryPK;

public interface ICategoryRepository extends JpaRepository<Category, CategoryPK> {

	@Query("SELECT e FROM Category e " + "Where e.id.id = :id")
	public List<Category> getListCategory(@Param("id") String id);
}
