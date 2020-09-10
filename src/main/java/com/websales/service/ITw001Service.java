package com.websales.service;

import com.websales.model.QuestionBasicModel;
import com.websales.model.User;

public interface ITw001Service {

	void insertNewExam(QuestionBasicModel questionBasicModel, User user) throws Exception;
}
