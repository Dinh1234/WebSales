package com.websales.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.websales.common.util.GenerateUtil;
import com.websales.entity.HistoryExamBasic;
import com.websales.entity.HistoryExamDetail;
import com.websales.model.AnserModel;
import com.websales.model.AnswerModelFE;
import com.websales.model.QuestionBasicModelFE;
import com.websales.model.QuestionModel;
import com.websales.model.QuestionModelFE;
import com.websales.model.User;
import com.websales.repository.ITw002Repository;
import com.websales.service.ITw002Service;

@Service
public class Tw002ServiceIml implements ITw002Service {

	@Autowired
	private ITw002Repository tw002Repository;

	@Override
	public QuestionBasicModelFE getListAnswer(String id, String type) {

		// get data answer from db
		List<Object[]> listAnsertBf = tw002Repository.getQuestion(id, type);

		ArrayList<QuestionModel> listQuestion = new ArrayList<>();

		QuestionBasicModelFE basicModel = new QuestionBasicModelFE();

		// get list question id
		QuestionModel questionModel = null;
		for (Object[] question : listAnsertBf) {

			if (!checkContent((String) question[0], listQuestion)) {
				questionModel = new QuestionModel();

				questionModel.setQuestionDetailCode(question[12].toString());
				questionModel.setQuestionId((String) question[0]);
				questionModel.setQuestion((String) question[1]);
				questionModel.setType((String) question[4]);
				basicModel.setQuestionBasicId((String) question[7]);
				basicModel.setSubjectName((String) question[8]);
				basicModel.setTimeOver((String) question[9]);
				basicModel.setSubjectId((String) question[11]);

				listQuestion.add(questionModel);
			}
		}

		// setting for list answer model
		ArrayList<AnserModel> listAnswer = null;
		AnserModel answer = null;

		for (QuestionModel question : listQuestion) {
			listAnswer = new ArrayList<>();

			for (Object[] object : listAnsertBf) {
				if (StringUtils.equals((String) object[0], question.getQuestionId())) {
					answer = new AnserModel();

					answer.setAnswerCd1((String) object[2]);
					answer.setAnswerName1((String) object[3]);
					answer.setAnswerCd2((String) object[5]);
					answer.setAnswerName2((String) object[6]);
					answer.setAnswerId((String) object[10]);

					listAnswer.add(answer);
				}
			}

			question.setListAnswer(listAnswer);
		}

		basicModel.setListQuestion(listQuestion);

		return basicModel;
	}

	@Override
	public HashMap<String, Object> insert(QuestionModelFE inputModel, User user) {
		
		HashMap<String, Object> data = new HashMap<String, Object>();

		HistoryExamBasic hisBasic = new HistoryExamBasic();

		List<HistoryExamDetail> listHistoryExamDetail = new ArrayList<>();
		HistoryExamDetail hisDetail = null;

		hisBasic.setQuestionBasicId(inputModel.getQuestionBasicId());
		hisBasic.setQuestionType(inputModel.getTypeQuestion());
		hisBasic.setTimeWorkExam(inputModel.getTimeWork());
		hisBasic.setUserExamId(inputModel.getUserExam());
		hisBasic.setId(GenerateUtil.generateID(user));
		hisBasic.setCreateDate(new Date());
		hisBasic.setCreateProgram("TW002");
		hisBasic.setCreateUser(inputModel.getUserExam());
		hisBasic.setDelFlag("0");
		hisBasic.setUpdateDate(new Date());
		hisBasic.setUpdateProgram("TW002");
		hisBasic.setUpdateUser(inputModel.getUserExam());
		hisBasic.setTimeStartExam("start");

		List<Object[]> listQuestionForCheckResult = this.tw002Repository
				.getQuestionForCheckResultByExamCode(inputModel.getQuestionBasicId());
		
		StringBuilder answerMany = null;

		for (Object[] object : listQuestionForCheckResult) {

			hisDetail = new HistoryExamDetail();

			hisDetail.setQuestionResult((String) object[3]);
			hisDetail.setQuestionType((String) object[1]);
			hisDetail.setQuestionDetailId((String) object[2]);
			
			answerMany = new StringBuilder();
			
			for (AnswerModelFE answer : inputModel.getListAnswer()) {
				if (StringUtils.equals(answer.getQuestionDetailId(), (String) object[2])) {
					if(answerMany.length() != 0) {
						answerMany.append(",");
					}
					answerMany.append(answer.getAnswerCd1());
				}
				
				hisDetail.setAnswerResult(answerMany.toString());
			}
			hisDetail.setId(GenerateUtil.generateID(user));
			hisDetail.setCreateDate(new Date());
			hisDetail.setCreateProgram("TW002");
			hisDetail.setCreateUser(inputModel.getUserExam());
			hisDetail.setDelFlag("0");
			hisDetail.setUpdateDate(new Date());
			hisDetail.setUpdateProgram("TW002");
			hisDetail.setUpdateUser(inputModel.getUserExam());
			hisDetail.setHistoryExamBasic(hisBasic);
			
			listHistoryExamDetail.add(hisDetail);

		}

		hisBasic.setHistoryExamDetails(listHistoryExamDetail);
		
		tw002Repository.save(hisBasic);
		//iHistoryExamDetailRepository.saveAll(listHistoryExamDetail);
		
		data.put("status", "OK");
		data.put("questionBasicId", inputModel.getQuestionBasicId());
		data.put("questionType", inputModel.getTypeQuestion());
		data.put("subjectType", inputModel.getSubjectID());
		
		return data;

	}

	private boolean checkContent(String id, ArrayList<QuestionModel> list) {

		boolean check = false;

		for (QuestionModel ques : list) {
			if (StringUtils.equals(ques.getQuestionId(), id)) {
				check = true;
				break;
			}
		}

		return check;
	}

}
