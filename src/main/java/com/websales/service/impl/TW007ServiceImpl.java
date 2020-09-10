package com.websales.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.websales.common.util.MessagesUtil;
import com.websales.common.util.WebUtils;
import com.websales.model.TW002Model;
import com.websales.model.User;
import com.websales.repository.IQuestionBasictRepository;
import com.websales.service.ITW007Service;

@Service
public class TW007ServiceImpl implements ITW007Service {

	@Autowired
	private IQuestionBasictRepository questionBasicRepo;

	@SuppressWarnings("deprecation")
	@Override
	public HashMap<String, Object> getTestList(User user, String subjectType, String questionType, String questionBasicId,
			int start, int length, String orderColumn, String orderDirection) {

		if ("contentQuestion".equals(orderColumn)) orderColumn = "content";
		if ("typeQuestion".equals(orderColumn)) orderColumn = "type";
		if ("timeStartExam".equals(orderColumn)) orderColumn = "time_start_exam";
		if ("timeEndExam".equals(orderColumn)) orderColumn = "time_end_exam";
		if ("timeOverExam".equals(orderColumn)) orderColumn = "TIME_OVER_EXAM";
		if ("countExam".equals(orderColumn)) orderColumn = "countExam";
		if ("highestScore".equals(orderColumn)) orderColumn = "highestScore";
		Sort sort;
		if (orderDirection.equalsIgnoreCase(Direction.ASC.toString())) {
			sort = new Sort(new Sort.Order(Direction.ASC, orderColumn));
		} else {
			sort = new Sort(new Sort.Order(Direction.DESC, orderColumn));
		}

		int page = start / length;
		Pageable pageable = new PageRequest(page, length, sort);
		HashMap<String, Object> data = new HashMap<>();

		List<TW002Model> listQuestion = new ArrayList<>();
		Page<Object[]> listTest = questionBasicRepo.getListTest(subjectType, questionType, questionBasicId, pageable);

		TW002Model model = null;
		for (Object[] obj : listTest.getContent()) {
			model = new TW002Model();
			model.setId(String.valueOf(obj[0]));
			
			model.setContentQuestion(String.valueOf(obj[2]));
			model.setTimeStartExam(String.valueOf(obj[4]));
			model.setTimeEndExam(String.valueOf(obj[5]));
			model.setTimeOverExam(String.valueOf(obj[6]));
			model.setCountExam(String.valueOf(obj[8]));
			model.setCreateUser(String.valueOf(obj[9]));
			//model.setHighestScore(String.valueOf(obj[7]) +"/"+ String.valueOf(obj[7]));
			
			if ("en".equals(user.getLocale().toString())) {
				model.setTypeQuestion(String.valueOf(obj[11]));
			} else {
				model.setTypeQuestion(String.valueOf(obj[10]));
			}
			StringBuilder buttonAction = new StringBuilder();
			if ("ROLE_USER".equals(WebUtils.getUserRole())) {
				
				buttonAction.append("<button type = 'button' class='btn btn-secondary mr-1' onclick = 'executeSubmit(this)' value='1' questionId='"
						+ model.getId() + "' typeQuestion='" + model.getTypeQuestion() + "'>"
						+ MessagesUtil.getMessage(user, "tw007.action.openTest") + "</button>");
				
				//buttonAction.append("<button type = 'button' class='btn btn-secondary mr-1' onclick = 'executeSubmit(this)' value='2' questionId='"
				//		+ model.getId() + "' typeQuestion='" + model.getTypeQuestion() + "'>"
				//		+ MessagesUtil.getMessage(user, "tw007.action.detail") + "</button>");
			} else if ("ROLE_ADMIN".equals(WebUtils.getUserRole())) {
				buttonAction.append("<button type = 'button' class='btn btn-secondary mr-1' onclick = 'executeSubmit(this)' value='3' questionId='"
						+ model.getId() + "' typeQuestion='" + model.getTypeQuestion() + "'>"
						+ MessagesUtil.getMessage(user, "tw007.action.update") + "</button>");
				
				buttonAction.append("<button type = 'button' class='btn btn-secondary mr-1' onclick = 'executeSubmit(this)' value='4' questionId='"
						+ model.getId() + "' typeQuestion='" + model.getTypeQuestion() + "'>"
						+ MessagesUtil.getMessage(user, "tw007.action.delete") + "</button>");
			}
//					
			model.setButtonAction(buttonAction.toString());
			//if (""WebUtils.getUserRole()}
			listQuestion.add(model);
			
		}

		// Push data
		data.put("data", listQuestion);
		data.put("recordsTotal", listTest.getTotalElements());
		data.put("recordsFiltered", listTest.getTotalElements());
		return data;
	}
}
