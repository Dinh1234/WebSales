package com.websales.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import com.websales.common.util.MessagesUtil;
import com.websales.model.TW002Model;
import com.websales.model.TW004Model;
import com.websales.service.ICategoryService;
import com.websales.service.ISubjectService;

@Controller
public class TW004Controller extends BaseController {

	@Autowired
	private ISubjectService subjectService;

	@Autowired
	private ICategoryService categoryService;

	@RequestMapping(value = "/tw004", method = RequestMethod.GET)
	public String init(Model model, HttpServletResponse response, HttpServletRequest request) {

		initial(model);

		model.addAttribute("titleScreen", MessagesUtil.getMessage(getUser(), "tw004.title"));
		model.addAttribute("TW004Form", new TW004Model());
		return "app/tw004";
	}

	@RequestMapping(value = "/tw004", method = RequestMethod.POST)
	public ModelAndView submit(Model model, HttpServletResponse response, HttpServletRequest request,
			TW004Model tw004Model) {

		initial(model);

		// TODO: Check xem neu la thi online, ID da thoa man dieu kien chua
		if (StringUtils.isEmpty(tw004Model.getId()) || !"ON".equals(tw004Model.getTypeQuestion())) {

			model.addAttribute("titleScreen", MessagesUtil.getMessage(getUser(), "tw004.title"));
			model.addAttribute("messageError", "Không tìm thấy phòng thi");
			model.addAttribute("TW004Form", tw004Model);
			return new ModelAndView("app/tw004");
		}
		
		//Neu truong hop thoa man dieu kien thi truyen param den tw002
		TW002Model tw002Model = new TW002Model();
		tw002Model.setId(tw004Model.getId());
		tw002Model.setTypeQuestion(tw004Model.getTypeQuestion());
		//model.addAttribute(tw002Model);
		ModelMap modelMap = new ModelMap();
		model.addAttribute(modelMap);
		request.setAttribute(View.RESPONSE_STATUS_ATTRIBUTE, HttpStatus.TEMPORARY_REDIRECT);
		return new ModelAndView("redirect:/tw002", modelMap);
	}
}