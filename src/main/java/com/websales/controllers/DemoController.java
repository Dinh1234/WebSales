package com.websales.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.websales.common.util.MessagesUtil;
import com.websales.model.TW003Model;

@Controller
public class DemoController extends BaseController{

	@RequestMapping(value = "/demo", method = { RequestMethod.GET, RequestMethod.POST })
	public String init(Model model, TW003Model form) {

		initial(model);

		
		return "other/demo";
	}
}
