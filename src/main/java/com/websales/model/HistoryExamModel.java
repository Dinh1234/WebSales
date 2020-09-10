package com.websales.model;

import java.io.Serializable;

public class HistoryExamModel implements Serializable {
	private static final long serialVersionUID = 1L;

	private String nameStudent;

	private String idStudent;

	private String score;

	private String timeExam;

	private String rank;

	private String answerCorrect;

	public HistoryExamModel() {
	}

	public HistoryExamModel(String nameStudent, String idStudent, String score, String timeExam, String rank,
			String answerCorrect) {
		super();
		this.nameStudent = nameStudent;
		this.idStudent = idStudent;
		this.score = score;
		this.timeExam = timeExam;
		this.rank = rank;
		this.answerCorrect = answerCorrect;
	}

	public String getNameStudent() {
		return nameStudent;
	}

	public void setNameStudent(String nameStudent) {
		this.nameStudent = nameStudent;
	}

	public String getIdStudent() {
		return idStudent;
	}

	public void setIdStudent(String idStudent) {
		this.idStudent = idStudent;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public String getTimeExam() {
		return timeExam;
	}

	public void setTimeExam(String timeExam) {
		this.timeExam = timeExam;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public String getAnswerCorrect() {
		return answerCorrect;
	}

	public void setAnswerCorrect(String answerCorrect) {
		this.answerCorrect = answerCorrect;
	}

}