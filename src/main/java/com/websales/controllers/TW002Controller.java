package com.websales.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.websales.common.util.MessagesUtil;
import com.websales.model.QuestionBasicModelFE;
import com.websales.model.TW002Model;
import com.websales.service.ITw002Service;

@Controller
public class TW002Controller extends BaseController {

	@Autowired
	private ITw002Service tw002Service;

	@RequestMapping(value = "/tw002", method = { RequestMethod.GET, RequestMethod.POST })
	public String init(Model model, HttpServletRequest request, TW002Model sourceModel) {

		System.out.println("SOURCE: " + sourceModel);
		initial(model);
		
		QuestionBasicModelFE dataRender = tw002Service.getListAnswer(sourceModel.getId(), sourceModel.getTypeQuestion());

		model.addAttribute("titleScreen", MessagesUtil.getMessage(getUser(), "tw002.title"));

		model.addAttribute("examCode", sourceModel.getId());

		model.addAttribute("data", dataRender.getListQuestion());
		
		model.addAttribute("userName", getUser().getName());
		
		model.addAttribute("userID", getUser().getUserId());
		
		model.addAttribute("examCd", dataRender.getQuestionBasicId());
		
		model.addAttribute("timeStart", dataRender.getTimeOver());
		
		model.addAttribute("subjectID", dataRender.getSubjectId());
		
		System.out.println("subjectID " + dataRender.getSubjectId());
		
		model.addAttribute("subjectName", dataRender.getSubjectName());
		
		model.addAttribute("countExam", dataRender.getCountExam());
		
		model.addAttribute("questionType", sourceModel.getTypeQuestion());

		return "app/tw002";
	}

	public String checkPoint(Model model, HttpServletRequest request) {

		return "";
	}
}