package com.websales.controllers.API;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.websales.model.QuestionBasicModel;
import com.websales.model.User;
import com.websales.service.ITw001Service;

@RestController
public class TW001APIController {

	@Autowired
	ITw001Service tw001Service;

	@RequestMapping(value = "/api/tw001/createNewExam", method = RequestMethod.POST, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public HashMap<String, Object> insertNewExam(HttpServletRequest request,
			@RequestBody QuestionBasicModel questionBasicModel) throws Exception {

		HashMap<String, Object> data = new HashMap<String, Object>();

		User user = (User) request.getSession().getAttribute("user");
		tw001Service.insertNewExam(questionBasicModel, user);

		data.put("statusCode", "OK");
		// Return data
		return data;
	}
}