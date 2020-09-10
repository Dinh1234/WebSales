package com.websales.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.websales.model.User;
import com.websales.repository.IQuestionBasictRepository;
import com.websales.service.ISubjectService;
import com.websales.service.ITw005Service;

@Service
public class TW005ServiceImpl implements ITw005Service {

	@Autowired
	private ISubjectService subjectService;

	@Autowired
	IQuestionBasictRepository questionBasictRepository;

	@Override
	public HashMap<String, Object> getDataInit(User user) throws Exception {
		HashMap<String, Object> data = new HashMap<String, Object>();

		// Math/History
		data.put("listSubjectType", this.subjectService.getListSubject(user));

		// ********
		List<Object[]> listExamTitle = questionBasictRepository.getListExamTitle(user.getUserId());
		List<Object[]> listExamTitleMap = new ArrayList<>();

		for (Object[] exam : listExamTitle) {
			listExamTitleMap.add(exam);
		}

		data.put("listExamTitle", listExamTitleMap);

		// Return data
		return data;
	}

}
