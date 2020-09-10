package com.websales.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.websales.common.util.MessagesUtil;
import com.websales.model.TW003Model;

@Controller
public class TW003Controller extends BaseController {

	@RequestMapping(value = "/tw003", method = { RequestMethod.GET, RequestMethod.POST })
	public String init(Model model, TW003Model form) {

		initial(model);

		form = new TW003Model("orderBasicId", "subjectId", "subjectName", "timeSrartExam", "timeEndExam",
				"timeOverExam", "userCreateId", "userCreateName", "123", "456");
		model.addAttribute("TW003Form", form);
		model.addAttribute("titleScreen", MessagesUtil.getMessage(getUser(), "tw003.title"));
		return "app/tw003";
	}
}