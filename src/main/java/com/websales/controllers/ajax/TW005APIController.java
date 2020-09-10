package com.websales.controllers.API;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.websales.common.util.MessagesUtil;
import com.websales.model.User;
import com.websales.service.ITw005Service;

@RestController
public class TW005APIController {

	@Autowired
	ITw005Service tw005Service;

	@RequestMapping(value = "/api/tw005/getDataInit", method = RequestMethod.GET)
	public @ResponseBody HashMap<String, Object> getDataInit(HttpServletRequest request) throws Exception {

		HashMap<String, Object> data = new HashMap<String, Object>();

		User user = (User) request.getSession().getAttribute("user");
		data = tw005Service.getDataInit(user);

		data.put("titleScreenRefer", MessagesUtil.getMessage(user, "tw005.title"));
		data.put("statusCode", "OK");
		// Return data
		return data;
	}
}