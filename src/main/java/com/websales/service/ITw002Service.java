package com.websales.service;

import java.util.HashMap;

import com.websales.model.QuestionBasicModelFE;
import com.websales.model.QuestionModelFE;
import com.websales.model.User;

public interface ITw002Service {

	public QuestionBasicModelFE getListAnswer(String id, String type);
	
	public HashMap<String, Object> insert(QuestionModelFE inputModel, User user);
}
