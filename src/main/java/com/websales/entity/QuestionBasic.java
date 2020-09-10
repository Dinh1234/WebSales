package com.websales.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the question_basic database table.
 * 
 */
@Entity
@Table(name="question_basic")
@NamedQuery(name="QuestionBasic.findAll", query="SELECT q FROM QuestionBasic q")
public class QuestionBasic implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	@Lob
	private String content;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CREATE_DATE")
	private Date createDate;

	@Column(name="CREATE_PROGRAM")
	private String createProgram;

	@Column(name="CREATE_USER")
	private String createUser;

	@Column(name="DEL_FLAG")
	private String delFlag;

	private String score;

	@Column(name="TIME_END_EXAM")
	private String timeEndExam;

	@Column(name="TIME_OVER_EXAM")
	private String timeOverExam;

	@Column(name="TIME_START_EXAM")
	private String timeStartExam;

	private String type;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="UPDATE_DATE")
	private Date updateDate;

	@Column(name="UPDATE_PROGRAM")
	private String updateProgram;

	@Column(name="UPDATE_USER")
	private String updateUser;

	//bi-directional many-to-one association to Subject
	@ManyToOne(fetch=FetchType.LAZY)
	private Subject subject;

	//bi-directional many-to-one association to QuestionDetail
	@OneToMany(mappedBy="questionBasic")
	private List<QuestionDetail> questionDetails;

	public QuestionBasic() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
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

	public String getScore() {
		return this.score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public String getTimeEndExam() {
		return this.timeEndExam;
	}

	public void setTimeEndExam(String timeEndExam) {
		this.timeEndExam = timeEndExam;
	}

	public String getTimeOverExam() {
		return this.timeOverExam;
	}

	public void setTimeOverExam(String timeOverExam) {
		this.timeOverExam = timeOverExam;
	}

	public String getTimeStartExam() {
		return this.timeStartExam;
	}

	public void setTimeStartExam(String timeStartExam) {
		this.timeStartExam = timeStartExam;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
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

	public Subject getSubject() {
		return this.subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public List<QuestionDetail> getQuestionDetails() {
		return this.questionDetails;
	}

	public void setQuestionDetails(List<QuestionDetail> questionDetails) {
		this.questionDetails = questionDetails;
	}

	public QuestionDetail addQuestionDetail(QuestionDetail questionDetail) {
		getQuestionDetails().add(questionDetail);
		questionDetail.setQuestionBasic(this);

		return questionDetail;
	}

	public QuestionDetail removeQuestionDetail(QuestionDetail questionDetail) {
		getQuestionDetails().remove(questionDetail);
		questionDetail.setQuestionBasic(null);

		return questionDetail;
	}

}