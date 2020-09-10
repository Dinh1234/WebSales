package com.websales.service.impl;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.websales.common.util.DateUtil;
import com.websales.entity.QuestionBasic;
import com.websales.model.HistoryExamModel;
import com.websales.repository.IHistoryExamBasictRepository;
import com.websales.repository.IQuestionBasictRepository;
import com.websales.service.ITw003Service;

@Service
public class TW003ServiceImpl implements ITw003Service {

	@Autowired
	IQuestionBasictRepository questionBasicReop;

	@Autowired
	IHistoryExamBasictRepository historyExamBasicRepo;;

	@Override
	public HashMap<String, Object> getListUserTestOnline(String subjectType, String questionType,
			String questionBasicId) throws Exception {

		HashMap<String, Object> data = new HashMap<>();

		// NOT APPLY VALIDATE YET
		// if (!validate(subjectType, questionType, questionBasicId, data)) {
		// return data;
		// }

		List<HistoryExamModel> listHistory = new ArrayList<>();

		HistoryExamModel model = null;
		int rank;
		List<Object[]> objList = historyExamBasicRepo.getListTestById(questionBasicId);
		if (!CollectionUtils.isEmpty(objList)) {
			for (Object[] obj : objList) {
				model = new HistoryExamModel();
				model.setNameStudent(String.valueOf(obj[2]));
				model.setIdStudent(String.valueOf(obj[1]));
				model.setScore(String.valueOf(obj[5]));
				model.setTimeExam(String.valueOf(obj[7]));
				model.setAnswerCorrect(String.valueOf(obj[5]));
				listHistory.add(model);

				rank = Integer.parseInt(String.valueOf(obj[5])) / Integer.parseInt(String.valueOf(obj[4])) * 100;

				if (rank == 100) {
					model.setRank("Xuất sắc");
				} else if (rank >= 85) {
					model.setRank("Giỏi");
				} else if (rank >= 65) {
					model.setRank("Khá");
				} else if (rank >= 50) {
					model.setRank("Trung bình");
				} else {
					model.setRank("Yếu");
				}
			}
		}

		data.put("data", listHistory);
		return data;
	}

	private boolean validate(String subjectType, String questionType, String questionBasicId,
			HashMap<String, Object> data) throws ParseException {

		if (StringUtils.isEmpty(subjectType) || StringUtils.isEmpty(questionType)
				|| StringUtils.isEmpty(questionBasicId)) {
			data.put("error", "Đang thiếu dữ liệu đầu vào");
			return false;
		}

		if (!subjectType.toUpperCase().equals("ON")) {
			data.put("error", "Màn hình này chỉ hiển thị dữ liệu của đề thi online");
			return false;
		}

		QuestionBasic question = questionBasicReop.getQuestionBasicByIdAndSubJectAndType(subjectType, questionType,
				questionBasicId);

		if (question == null) {
			data.put("error", "Không tìm thấy dữ liệu");
			return false;
		}

		Date timeStartExam = DateUtil.convertStringtoDate(question.getTimeStartExam(), "yyyy-MM-dd HH:mm");
		DateUtils.addMinutes(timeStartExam, Integer.parseInt(question.getTimeOverExam() + 10));
		Date dateNow = new Date();
		if (dateNow.after(timeStartExam)) {
			data.put("error", "Đã quá thời gian truy xuất điểm thi online...");
			return false;
		}

		return true;
	}

}
