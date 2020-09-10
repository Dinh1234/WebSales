package com.websales.controllers.API;

import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.websales.model.QuestionModelFE;
import com.websales.model.User;
import com.websales.service.ITw002Service;

@RestController
public class Tw002APIController {
	
	@Resource
	ITw002Service tw002Service;
	
	@RequestMapping(value = "api/tw002/saveAnswer", method = RequestMethod.POST, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	@ResponseBody
	public HashMap<String, Object> getMstFoodList(HttpServletRequest request, @RequestBody QuestionModelFE input){
		
		User user = (User) request.getSession().getAttribute("user");
		
		HashMap<String, Object> result = tw002Service.insert(input, user);
		
		return result;
	}
}
