package com.websales.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the history_exam_detail database table.
 * 
 */
@Entity
@Table(name="history_exam_detail")
@NamedQuery(name="HistoryExamDetail.findAll", query="SELECT h FROM HistoryExamDetail h")
public class HistoryExamDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	@Column(name="ANSWER_RESULT")
	private String answerResult;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CREATE_DATE")
	private Date createDate;

	@Column(name="CREATE_PROGRAM")
	private String createProgram;

	@Column(name="CREATE_USER")
	private String createUser;

	@Column(name="DEL_FLAG")
	private String delFlag;

	@Column(name="QUESTION_DETAIL_ID")
	private String questionDetailId;

	@Column(name="QUESTION_RESULT")
	private String questionResult;

	@Column(name="QUESTION_TYPE")
	private String questionType;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="UPDATE_DATE")
	private Date updateDate;

	@Column(name="UPDATE_PROGRAM")
	private String updateProgram;

	@Column(name="UPDATE_USER")
	private String updateUser;

	//bi-directional many-to-one association to HistoryExamBasic
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="HISTORY_EXAM_BASIC_ID")
	private HistoryExamBasic historyExamBasic;

	public HistoryExamDetail() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAnswerResult() {
		return this.answerResult;
	}

	public void setAnswerResult(String answerResult) {
		this.answerResult = answerResult;
	}

	public Date getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getCreateProgram() {
		return this.createProgram;
	}

	public void setCreateProgram(String createProgram) {
		this.createProgram = createProgram;
	}

	public String getCreateUser() {
		return this.createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public String getDelFlag() {
		return this.delFlag;
	}

	public void setDelFlag(String delFlag) {
		this.delFlag = delFlag;
	}

	public String getQuestionDetailId() {
		return this.questionDetailId;
	}

	public void setQuestionDetailId(String questionDetailId) {
		this.questionDetailId = questionDetailId;
	}

	public String getQuestionResult() {
		return this.questionResult;
	}

	public void setQuestionResult(String questionResult) {
		this.questionResult = questionResult;
	}

	public String getQuestionType() {
		return this.questionType;
	}

	public void setQuestionType(String questionType) {
		this.questionType = questionType;
	}

	public Date getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public String getUpdateProgram() {
		return this.updateProgram;
	}

	public void setUpdateProgram(String updateProgram) {
		this.updateProgram = updateProgram;
	}

	public String getUpdateUser() {
		return this.updateUser;
	}

	public void setUpdateUser(String updateUser) {
		this.updateUser = updateUser;
	}

	public HistoryExamBasic getHistoryExamBasic() {
		return this.historyExamBasic;
	}

	public void setHistoryExamBasic(HistoryExamBasic historyExamBasic) {
		this.historyExamBasic = historyExamBasic;
	}

}