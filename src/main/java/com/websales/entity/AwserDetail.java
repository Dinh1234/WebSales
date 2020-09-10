package com.websales.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the awser_detail database table.
 * 
 */
@Entity
@Table(name="awser_detail")
@NamedQuery(name="AwserDetail.findAll", query="SELECT a FROM AwserDetail a")
public class AwserDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	@Column(name="AWSER_DETAIL_CD_1")
	private String awserDetailCd1;

	@Column(name="AWSER_DETAIL_CD_2")
	private String awserDetailCd2;

	@Lob
	@Column(name="AWSER_DETAIL_NAME_1")
	private String awserDetailName1;

	@Lob
	@Column(name="AWSER_DETAIL_NAME_2")
	private String awserDetailName2;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CREATE_DATE")
	private Date createDate;

	@Column(name="CREATE_PROGRAM")
	private String createProgram;

	@Column(name="CREATE_USER")
	private String createUser;

	@Column(name="DEL_FLAG")
	private String delFlag;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="UPDATE_DATE")
	private Date updateDate;

	@Column(name="UPDATE_PROGRAM")
	private String updateProgram;

	@Column(name="UPDATE_USER")
	private String updateUser;

	//bi-directional many-to-one association to QuestionDetail
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="QUESTION_DETAIL_ID")
	private QuestionDetail questionDetail;

	public AwserDetail() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAwserDetailCd1() {
		return this.awserDetailCd1;
	}

	public void setAwserDetailCd1(String awserDetailCd1) {
		this.awserDetailCd1 = awserDetailCd1;
	}

	public String getAwserDetailCd2() {
		return this.awserDetailCd2;
	}

	public void setAwserDetailCd2(String awserDetailCd2) {
		this.awserDetailCd2 = awserDetailCd2;
	}

	public String getAwserDetailName1() {
		return this.awserDetailName1;
	}

	public void setAwserDetailName1(String awserDetailName1) {
		this.awserDetailName1 = awserDetailName1;
	}

	public String getAwserDetailName2() {
		return this.awserDetailName2;
	}

	public void setAwserDetailName2(String awserDetailName2) {
		this.awserDetailName2 = awserDetailName2;
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

	public QuestionDetail getQuestionDetail() {
		return this.questionDetail;
	}

	public void setQuestionDetail(QuestionDetail questionDetail) {
		this.questionDetail = questionDetail;
	}

}