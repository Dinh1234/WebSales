package com.websales.model;

import java.util.ArrayList;

public class QuestionDetailsModel {
	private String questionNo;
	private String questionClassification;
	private String questionCoefficientPoint;
	private String questionContent;
	private String answerCorrect;
	private ArrayList<AnserModel> listAnserModel;

	public String getQuestionClassification() {
		return questionClassification;
	}

	public void setQuestionClassification(String questionClassification) {
		this.questionClassification = questionClassification;
	}

	public String getQuestionCoefficientPoint() {
		return questionCoefficientPoint;
	}

	public void setQuestionCoefficientPoint(String questionCoefficientPoint) {
		this.questionCoefficientPoint = questionCoefficientPoint;
	}

	public String getQuestionNo() {
		return questionNo;
	}

	public void setQuestionNo(String questionNo) {
		this.questionNo = questionNo;
	}

	public String getQuestionContent() {
		return questionContent;
	}

	public void setQuestionContent(String questionContent) {
		this.questionContent = questionContent;
	}

	public String getAnswerCorrect() {
		return answerCorrect;
	}

	public void setAnswerCorrect(String answerCorrect) {
		this.answerCorrect = answerCorrect;
	}

	public ArrayList<AnserModel> getListAnserModel() {
		return listAnserModel;
	}

	public void setListAnserModel(ArrayList<AnserModel> listAnserModel) {
		this.listAnserModel = listAnserModel;
	}
}
