package com.websales.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.websales.common.util.MessagesUtil;
import com.websales.service.ICategoryService;
import com.websales.service.ISubjectService;

/***
 *
 **/
@Controller
public class TW001Controller extends BaseController {

	@Autowired
	private ISubjectService subjectService;

	@Autowired
	private ICategoryService categoryService;

	@RequestMapping(value = "/tw001", method = RequestMethod.GET)
	public String init(Model model) {

		initial(model);

		// Online/Offline
		model.addAttribute("listExamType", this.categoryService.getListCategory(getUser(), "ETP"));

		// Math/History
		model.addAttribute("listSubjectType", this.subjectService.getListSubject(getUser()));

		// True-False/One Correct
		model.addAttribute("listQuestionClassification", this.categoryService.getListCategory(getUser(), "LCH"));
		model.addAttribute("titleScreen", MessagesUtil.getMessage(getUser(), "tw001.title"));
		return "app/tw001";
	}
}