package com.websales.model;

import java.util.List;

public class QuestionModel {
	
	private String questionDetailCode;

	private String questionId;

	private String question;
	
	private String type;
	
	private List<AnserModel> listAnswer;
	
	public String getQuestionDetailCode() {
		return questionDetailCode;
	}

	public void setQuestionDetailCode(String questionDetailCode) {
		this.questionDetailCode = questionDetailCode;
	}

	public String getQuestionId() {
		return questionId;
	}

	public void setQuestionId(String questionId) {
		this.questionId = questionId;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public List<AnserModel> getListAnswer() {
		return listAnswer;
	}

	public void setListAnswer(List<AnserModel> listAnswer) {
		this.listAnswer = listAnswer;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
