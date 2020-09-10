package com.websales.service;

import java.util.HashMap;

public interface ITw003Service {

	HashMap<String, Object> getListUserTestOnline(String subjectType, String questionType, String questionBasicId)
			throws Exception;
}
