package com.websales.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.websales.common.util.MessagesUtil;
import com.websales.service.ICategoryService;
import com.websales.service.ISubjectService;

@Controller
public class TW007Controller extends BaseController {

	@Autowired
	private ISubjectService subjectService;

	@Autowired
	private ICategoryService categoryService;

	@RequestMapping(value = "/tw007", method = RequestMethod.GET)
	public String init(Model model, HttpServletResponse response, HttpServletRequest request) {

		initial(model);

		model.addAttribute("listsubjectType", this.subjectService.getListSubject(getUser()));
		model.addAttribute("listQuestionType", this.categoryService.getListCategory(getUser(), "LBT"));
		model.addAttribute("titleScreen", MessagesUtil.getMessage(getUser(), "tw007.title"));
		return "app/tw007";
	}
}