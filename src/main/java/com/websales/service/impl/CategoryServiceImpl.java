package com.websales.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.websales.entity.Category;
import com.websales.model.CategoryModel;
import com.websales.model.User;
import com.websales.repository.ICategoryRepository;
import com.websales.service.ICategoryService;

@Service
public class CategoryServiceImpl implements ICategoryService {

	@Autowired
	ICategoryRepository categoryRepo;

	@Override
	public List<CategoryModel> getListCategory(User user, String id) {

		CategoryModel model = null;
		List<CategoryModel> list = new ArrayList<CategoryModel>();
		List<Category> subjectList = categoryRepo.getListCategory(id);
		for (Category category : subjectList) {
			model = new CategoryModel();
			model.setKey(category.getId().getKey());
			model.setValue(category.getValue());
			
			if(!"vn".equals(user.getLocale().toString())) {
				model.setValue(category.getValueEn());
			}
			list.add(model);
		}
		return list;
	}
}