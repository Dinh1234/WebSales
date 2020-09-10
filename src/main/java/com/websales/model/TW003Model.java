package com.websales.model;

import java.io.Serializable;

public class TW003Model implements Serializable {

	public TW003Model() {
		super();
	}

	public TW003Model(String orderBasicId, String subjectId, String subjectName, String timeSrartExam,
			String timeEndExam, String timeOverExam, String userCreateId, String userCreateName, String subjectType,
			String questionType) {
		super();
		this.orderBasicId = orderBasicId;
		this.subjectId = subjectId;
		this.subjectName = subjectName;
		this.timeSrartExam = timeSrartExam;
		this.timeEndExam = timeEndExam;
		this.timeOverExam = timeOverExam;
		this.userCreateId = userCreateId;
		this.userCreateName = userCreateName;
		this.subjectType = subjectType;
		this.questionType = questionType;
	}

	public String getOrderBasicId() {
		return orderBasicId;
	}

	public void setOrderBasicId(String orderBasicId) {
		this.orderBasicId = orderBasicId;
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

	public String getTimeSrartExam() {
		return timeSrartExam;
	}

	public void setTimeSrartExam(String timeSrartExam) {
		this.timeSrartExam = timeSrartExam;
	}

	public String getTimeEndExam() {
		return timeEndExam;
	}

	public void setTimeEndExam(String timeEndExam) {
		this.timeEndExam = timeEndExam;
	}

	public String getTimeOverExam() {
		return timeOverExam;
	}

	public void setTimeOverExam(String timeOverExam) {
		this.timeOverExam = timeOverExam;
	}

	public String getUserCreateId() {
		return userCreateId;
	}

	public void setUserCreateId(String userCreateId) {
		this.userCreateId = userCreateId;
	}

	public String getUserCreateName() {
		return userCreateName;
	}

	public void setUserCreateName(String userCreateName) {
		this.userCreateName = userCreateName;
	}

	public String getSubjectType() {
		return subjectType;
	}

	public void setSubjectType(String subjectType) {
		this.subjectType = subjectType;
	}

	public String getQuestionType() {
		return questionType;
	}

	public void setQuestionType(String questionType) {
		this.questionType = questionType;
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String orderBasicId;
	private String subjectId;
	private String subjectName;
	private String timeSrartExam;
	private String timeEndExam;
	private String timeOverExam;
	private String userCreateId;
	private String userCreateName;
	private String subjectType;
	private String questionType;
}
