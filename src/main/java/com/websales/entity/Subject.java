package com.websales.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the subject database table.
 * 
 */
@Entity
@NamedQuery(name="Subject.findAll", query="SELECT s FROM Subject s")
public class Subject implements Serializable {
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

	private String name;

	@Column(name="NAME_EN")
	private String nameEn;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="UPDATE_DATE")
	private Date updateDate;

	@Column(name="UPDATE_PROGRAM")
	private String updateProgram;

	@Column(name="UPDATE_USER")
	private String updateUser;

	//bi-directional many-to-one association to QuestionBasic
	@OneToMany(mappedBy="subject")
	private List<QuestionBasic> questionBasics;

	public Subject() {
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

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNameEn() {
		return this.nameEn;
	}

	public void setNameEn(String nameEn) {
		this.nameEn = nameEn;
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

	public List<QuestionBasic> getQuestionBasics() {
		return this.questionBasics;
	}

	public void setQuestionBasics(List<QuestionBasic> questionBasics) {
		this.questionBasics = questionBasics;
	}

	public QuestionBasic addQuestionBasic(QuestionBasic questionBasic) {
		getQuestionBasics().add(questionBasic);
		questionBasic.setSubject(this);

		return questionBasic;
	}

	public QuestionBasic removeQuestionBasic(QuestionBasic questionBasic) {
		getQuestionBasics().remove(questionBasic);
		questionBasic.setSubject(null);

		return questionBasic;
	}

}