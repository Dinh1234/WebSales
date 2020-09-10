package com.websales.service;

import java.util.List;

import com.websales.model.CategoryModel;
import com.websales.model.User;

public interface ICategoryService {

	List<CategoryModel> getListCategory(User user, String id);
}
