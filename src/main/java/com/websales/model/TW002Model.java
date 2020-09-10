package com.websales.model;

import java.io.Serializable;

public class TW002Model implements Serializable {
	public TW002Model(String id, String createUser, String timeOverExam, String timeStartExam,
			String contentQuestion, String timeEndExam, String typeQuestion, String countExam, String highestScore) {
		super();
		this.id = id;
		this.createUser = createUser;
		this.timeOverExam = timeOverExam;
		this.timeStartExam = timeStartExam;
		this.timeEndExam = timeEndExam;
		this.typeQuestion = typeQuestion;
		this.setContentQuestion(contentQuestion);
		this.countExam = countExam;
		this.highestScore = highestScore;
	}

	public TW002Model() {
	};

	private static final long serialVersionUID = 1L;

	private String id;

	private String contentQuestion;

	private String createUser;

	private String timeOverExam;

	private String timeStartExam;
	private String timeEndExam;
	private String typeQuestion;
	private String action;
	private String screenSource;
	private String countExam;//so lan thi
	private String highestScore;// diem cao nhat
	private String buttonAction;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public String getTimeOverExam() {
		return timeOverExam;
	}

	public void setTimeOverExam(String timeOverExam) {
		this.timeOverExam = timeOverExam;
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

	public String getContentQuestion() {
		return contentQuestion;
	}

	public void setContentQuestion(String contentQuestion) {
		this.contentQuestion = contentQuestion;
	}

	public String getTypeQuestion() {
		return typeQuestion;
	}

	public void setTypeQuestion(String typeQuestion) {
		this.typeQuestion = typeQuestion;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getScreenSource() {
		return screenSource;
	}

	public void setScreenSource(String screenSource) {
		this.screenSource = screenSource;
	}

	public String getCountExam() {
		return countExam;
	}

	public void setCountExam(String countExam) {
		this.countExam = countExam;
	}

	public String getHighestScore() {
		return highestScore;
	}

	public void setHighestScore(String highestScore) {
		this.highestScore = highestScore;
	}

	public String getButtonAction() {
		return buttonAction;
	}

	public void setButtonAction(String buttonAction) {
		this.buttonAction = buttonAction;
	}

}