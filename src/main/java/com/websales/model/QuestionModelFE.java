package com.websales.model;

import java.util.List;

public class QuestionModelFE {

	private String questionBasicId;
	
	private String userExam;
	
	private String timeStart;
	
	private String timeWork;
	
	private String subjectID;
	
	private String typeQuestion;
	
	private List<AnswerModelFE> listAnswer;

	public String getQuestionBasicId() {
		return questionBasicId;
	}

	public void setQuestionBasicId(String questionBasicId) {
		this.questionBasicId = questionBasicId;
	}

	public String getUserExam() {
		return userExam;
	}

	public void setUserExam(String userExam) {
		this.userExam = userExam;
	}

	public String getTimeStart() {
		return timeStart;
	}

	public void setTimeStart(String timeStart) {
		this.timeStart = timeStart;
	}

	public String getTimeWork() {
		return timeWork;
	}

	public void setTimeWork(String timeWork) {
		this.timeWork = timeWork;
	}

	public String getSubjectID() {
		return subjectID;
	}

	public void setSubjectID(String subjectID) {
		this.subjectID = subjectID;
	}

	public List<AnswerModelFE> getListAnswer() {
		return listAnswer;
	}

	public void setListAnswer(List<AnswerModelFE> listAnswer) {
		this.listAnswer = listAnswer;
	}

	public String getTypeQuestion() {
		return typeQuestion;
	}

	public void setTypeQuestion(String typeQuestion) {
		this.typeQuestion = typeQuestion;
	}
}
