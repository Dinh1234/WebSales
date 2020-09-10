package com.websales.model;

import java.util.List;

public class QuestionBasicModelFE {

	private String questionBasicId;
	
	private String timeOver;
	
	private String subjectId;
	
	private String subjectName;
	
	private String countExam;

	private List<QuestionModel> listQuestion;
	
	public String getQuestionBasicId() {
		return questionBasicId;
	}

	public void setQuestionBasicId(String questionBasicId) {
		this.questionBasicId = questionBasicId;
	}

	public String getTimeOver() {
		return timeOver;
	}

	public void setTimeOver(String timeOver) {
		this.timeOver = timeOver;
	}

	public String getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(String subjectId) {
		this.subjectId = subjectId;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public String getCountExam() {
		return countExam;
	}

	public void setCountExam(String countExam) {
		this.countExam = countExam;
	}

	public List<QuestionModel> getListQuestion() {
		return listQuestion;
	}

	public void setListQuestion(List<QuestionModel> listQuestion) {
		this.listQuestion = listQuestion;
	}
	
}
