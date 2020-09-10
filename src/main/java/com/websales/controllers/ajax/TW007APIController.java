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

import com.websales.common.util.WebUtils;
import com.websales.model.User;
import com.websales.service.ITW007Service;

@RestController
public class TW007APIController {

	@Autowired
	ITW007Service tw007Service;

	@RequestMapping(value = "/api/tw009/search", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public HashMap<String, Object> search(HttpServletRequest request,
			@RequestParam(value = "start", defaultValue = "1") int start,
			@RequestParam(value = "length", defaultValue = "10") int length,
			@RequestParam(value = "subjectType", defaultValue = "") String subjectType,
			@RequestParam(value = "questionType", defaultValue = "") String questionType,
			@RequestParam(value = "questionBasicId", defaultValue = "") String questionBasicId,
			@RequestParam(value = "orderColumn", defaultValue = "") String orderColumn,
			@RequestParam(value = "orderDirection", defaultValue = "asc") String orderDirection) throws Exception {

		User user = (User) request.getSession().getAttribute("user");
		
		// Get List Food
		HashMap<String, Object> data = tw007Service.getTestList(user, subjectType, questionType, questionBasicId, start,
				length, orderColumn, orderDirection);
		data.put("statusCode", "OK");

		// Return data
		return data;
	}

}
