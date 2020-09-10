package com.websales.model;

import java.util.ArrayList;

public class QuestionBasicModel {

	private String examClassification;
	private String examSubject;
	private String timeStartExam;
	private String timeEndExam;
	private String examDuration;
	private String examMaxNumber;
	private String examRange;
	private String examAfterOnline;
	private String examContent;

	public String getExamContent() {
		return examContent;
	}

	public void setExamContent(String examContent) {
		this.examContent = examContent;
	}

	private ArrayList<QuestionDetailsModel> listQuestionDetailsModel;

	public String getExamClassification() {
		return examClassification;
	}

	public void setExamClassification(String examClassification) {
		this.examClassification = examClassification;
	}

	public String getExamSubject() {
		return examSubject;
	}

	public void setExamSubject(String examSubject) {
		this.examSubject = examSubject;
	}

	public String getTimeStartExam() {
		return timeStartExam;
	}

	public void setTimeStartExam(String timeStartExam) {
		this.timeStartExam = timeStartExam;
	}

	public String getTimeEndExam() {
		return timeEndExam;
	}

	public void setTimeEndExam(String timeEndExam) {
		this.timeEndExam = timeEndExam;
	}

	public String getExamDuration() {
		return examDuration;
	}

	public void setExamDuration(String examDuration) {
		this.examDuration = examDuration;
	}

	public String getExamMaxNumber() {
		return examMaxNumber;
	}

	public void setExamMaxNumber(String examMaxNumber) {
		this.examMaxNumber = examMaxNumber;
	}

	public String getExamRange() {
		return examRange;
	}

	public void setExamRange(String examRange) {
		this.examRange = examRange;
	}

	public String getExamAfterOnline() {
		return examAfterOnline;
	}

	public void setExamAfterOnline(String examAfterOnline) {
		this.examAfterOnline = examAfterOnline;
	}

	public ArrayList<QuestionDetailsModel> getListQuestionDetailsModel() {
		return listQuestionDetailsModel;
	}

	public void setListQuestionDetailsModel(ArrayList<QuestionDetailsModel> listQuestionDetailsModel) {
		this.listQuestionDetailsModel = listQuestionDetailsModel;
	}
}
