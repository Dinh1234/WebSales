package com.websales.service;

import java.util.HashMap;

import com.websales.model.User;

public interface ITw005Service {

	HashMap<String, Object> getDataInit(User user) throws Exception;
}
