package com.websales.controllers.API;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.websales.service.ITw003Service;

@RestController
public class TW003APIController {

	@Autowired
	ITw003Service tw003Service;

	@RequestMapping(value = "/api/tw003/getHistoryExam", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public HashMap<String, Object> getMstFoodList(HttpServletRequest request,
			@RequestParam(value = "subjectType", defaultValue = "") String subjectType,
			@RequestParam(value = "questionType", defaultValue = "") String questionType,
			@RequestParam(value = "questionBasicId", defaultValue = "") String questionBasicId) throws Exception {

		// TODO:
		questionBasicId = "Q3";
		tw003Service.getListUserTestOnline(subjectType, questionType, questionBasicId);
		HashMap<String, Object> data = tw003Service.getListUserTestOnline(subjectType, questionType, questionBasicId);
		;

		data.put("statusCode", "OK");
		// Return data
		return data;
	}
}
