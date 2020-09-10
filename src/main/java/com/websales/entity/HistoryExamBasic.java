package com.websales.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the history_exam_basic database table.
 * 
 */
@Entity
@Table(name="history_exam_basic")
@NamedQuery(name="HistoryExamBasic.findAll", query="SELECT h FROM HistoryExamBasic h")
public class HistoryExamBasic implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CREATE_DATE")
	private Date createDate;

	@Column(name="CREATE_PROGRAM")
	private String createProgram;

	@Column(name="CREATE_USER")
	private String createUser;

	@Column(name="DEL_FLAG")
	private String delFlag;

	@Column(name="QUESTION_BASIC_ID")
	private String questionBasicId;

	@Column(name="QUESTION_TYPE")
	private String questionType;

	@Column(name="TIME_START_EXAM")
	private String timeStartExam;

	@Column(name="TIME_WORK_EXAM")
	private String timeWorkExam;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="UPDATE_DATE")
	private Date updateDate;

	@Column(name="UPDATE_PROGRAM")
	private String updateProgram;

	@Column(name="UPDATE_USER")
	private String updateUser;

	@Column(name="USER_EXAM_ID")
	private String userExamId;

	//bi-directional many-to-one association to HistoryExamDetail
	@OneToMany(mappedBy="historyExamBasic", cascade = {CascadeType.ALL} )
	private List<HistoryExamDetail> historyExamDetails;

	public HistoryExamBasic() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getQuestionBasicId() {
		return this.questionBasicId;
	}

	public void setQuestionBasicId(String questionBasicId) {
		this.questionBasicId = questionBasicId;
	}

	public String getQuestionType() {
		return this.questionType;
	}

	public void setQuestionType(String questionType) {
		this.questionType = questionType;
	}

	public String getTimeStartExam() {
		return this.timeStartExam;
	}

	public void setTimeStartExam(String timeStartExam) {
		this.timeStartExam = timeStartExam;
	}

	public String getTimeWorkExam() {
		return this.timeWorkExam;
	}

	public void setTimeWorkExam(String timeWorkExam) {
		this.timeWorkExam = timeWorkExam;
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

	public String getUserExamId() {
		return this.userExamId;
	}

	public void setUserExamId(String userExamId) {
		this.userExamId = userExamId;
	}

	public List<HistoryExamDetail> getHistoryExamDetails() {
		return this.historyExamDetails;
	}

	public void setHistoryExamDetails(List<HistoryExamDetail> historyExamDetails) {
		this.historyExamDetails = historyExamDetails;
	}

	public HistoryExamDetail addHistoryExamDetail(HistoryExamDetail historyExamDetail) {
		getHistoryExamDetails().add(historyExamDetail);
		historyExamDetail.setHistoryExamBasic(this);

		return historyExamDetail;
	}

	public HistoryExamDetail removeHistoryExamDetail(HistoryExamDetail historyExamDetail) {
		getHistoryExamDetails().remove(historyExamDetail);
		historyExamDetail.setHistoryExamBasic(null);

		return historyExamDetail;
	}

}