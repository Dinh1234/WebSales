//package com.websales.service.impl;
//
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.websales.common.util.GenerateUtil;
//import com.websales.entity.AwserDetail;
//import com.websales.entity.QuestionBasic;
//import com.websales.entity.QuestionDetail;
//import com.websales.entity.Subject;
//import com.websales.model.AnserModel;
//import com.websales.model.QuestionBasicModel;
//import com.websales.model.QuestionDetailsModel;
//import com.websales.model.User;
//import com.websales.repository.IAnswerRepository;
//import com.websales.repository.IQuestionBasictRepository;
//import com.websales.repository.IQuestionDetailsRepository;
//import com.websales.repository.ISubjectRepository;
//import com.websales.service.ITw001Service;
//
//@Service
//public class TW001ServiceImpl implements ITw001Service {
//
//	@Autowired
//	IQuestionBasictRepository questionBasicRepo;
//
//	@Autowired
//	IQuestionDetailsRepository questionDetailsRepo;
//
//	@Autowired
//	IAnswerRepository answerRepo;
//
//	@Autowired
//	ISubjectRepository subjectRepo;
//
//	@Override
//	public void insertNewExam(QuestionBasicModel questionBasicModel, User user) throws Exception {
//		SimpleDateFormat dtf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
//
//		String questionBasicId = GenerateUtil.generateID(user);
//
//		QuestionBasic questionBasicEntity = new QuestionBasic();
//		questionBasicEntity.setId(questionBasicId);
//		questionBasicEntity.setType(questionBasicModel.getExamClassification());
//		questionBasicEntity.setContent(questionBasicModel.getExamContent());
//		questionBasicEntity.setSubject(subjectRepo.findById(questionBasicModel.getExamSubject()).orElse(new Subject()));
//
//		if (questionBasicModel.getTimeStartExam().isEmpty()) {
//			questionBasicEntity.setTimeStartExam(dtf.format(new Date()));
//		} else {
//			questionBasicEntity.setTimeStartExam(questionBasicModel.getTimeStartExam());
//		}
//		questionBasicEntity.setTimeEndExam(questionBasicModel.getTimeEndExam());
//		questionBasicEntity.setTimeOverExam(questionBasicModel.getExamDuration());
//		questionBasicEntity.setTimeOverExam(questionBasicModel.getExamDuration());
//		questionBasicEntity.setScore(questionBasicModel.getExamMaxNumber());
//
//		questionBasicEntity.setDelFlag("0");
//		questionBasicEntity.setCreateUser(user.getUserId());
//		questionBasicEntity.setCreateProgram("tw001");
//		questionBasicEntity.setCreateDate(new Date());
//		questionBasicEntity.setUpdateUser(user.getUserId());
//		questionBasicEntity.setUpdateProgram("tw001");
//		questionBasicEntity.setUpdateDate(new Date());
//		questionBasicRepo.save(questionBasicEntity);
//
//		QuestionDetail questionDetail;
//		AwserDetail answerDetail;
//		String questionDetailsId;
//		String questionType;
//		for (QuestionDetailsModel questionDetailsModel : questionBasicModel.getListQuestionDetailsModel()) {
//			questionDetailsId = GenerateUtil.generateID(user);
//			questionDetail = new QuestionDetail();
//			questionDetail.setId(questionDetailsId);
//			questionDetail.setQuesttionDetailCode(Integer.parseInt(questionDetailsModel.getQuestionNo()));
//			questionDetail.setQuestionBasic(questionBasicEntity);
//			questionDetail.setQuestion(questionDetailsModel.getQuestionContent());
//			questionDetail.setAwserCorrect(questionDetailsModel.getAnswerCorrect());
//			questionDetail.setType(questionDetailsModel.getQuestionClassification());
//
//			questionDetail.setDelFlag("0");
//			questionDetail.setCreateUser(user.getUserId());
//			questionDetail.setCreateProgram("tw001");
//			questionDetail.setCreateDate(new Date());
//			questionDetail.setUpdateUser(user.getUserId());
//			questionDetail.setUpdateProgram("tw001");
//			questionDetail.setUpdateDate(new Date());
//			questionDetailsRepo.save(questionDetail);
//
//			questionType = questionDetailsModel.getQuestionClassification();
//
//			for (AnserModel anserModel : questionDetailsModel.getListAnserModel()) {
//				answerDetail = new AwserDetail();
//				answerDetail.setId(GenerateUtil.generateID(user));
//				answerDetail.setQuestionDetail(questionDetail);
//				answerDetail.setAwserDetailCd1(anserModel.getAnswerCd1());
//				answerDetail.setAwserDetailName1(anserModel.getAnswerName1());
//
//				if ("LCH004".equals(questionType)) {
//					answerDetail.setAwserDetailCd2(anserModel.getAnswerCd2());
//					answerDetail.setAwserDetailName2(anserModel.getAnswerName2());
//				}
//
//				answerDetail.setDelFlag("0");
//				answerDetail.setCreateUser(user.getUserId());
//				answerDetail.setCreateProgram("tw001");
//				answerDetail.setCreateDate(new Date());
//				answerDetail.setUpdateUser(user.getUserId());
//				answerDetail.setUpdateProgram("tw001");
//				answerDetail.setUpdateDate(new Date());
//				answerRepo.save(answerDetail);
//			}
//		}
//	}
//
//}
