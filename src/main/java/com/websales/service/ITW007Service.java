package com.websales.service;

import java.util.HashMap;

import com.websales.model.User;

public interface ITW007Service {

	HashMap<String, Object> getTestList(User user, String subjectType, String questionType, String questionBasicId,
			int start, int length, String orderColumn, String orderDirection);
}
