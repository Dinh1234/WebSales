package com.websales.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the question_detail database table.
 * 
 */
@Entity
@Table(name="question_detail")
@NamedQuery(name="QuestionDetail.findAll", query="SELECT q FROM QuestionDetail q")
public class QuestionDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	@Column(name="AWSER_CORRECT")
	private String awserCorrect;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="CREATE_DATE")
	private Date createDate;

	@Column(name="CREATE_PROGRAM")
	private String createProgram;

	@Column(name="CREATE_USER")
	private String createUser;

	@Column(name="DEL_FLAG")
	private String delFlag;

	@Column(name="ID_REFERENCE")
	private String idReference;

	@Lob
	private String question;

	@Column(name="QUESTTION_DETAIL_CODE")
	private int questtionDetailCode;

	private String type;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="UPDATE_DATE")
	private Date updateDate;

	@Column(name="UPDATE_PROGRAM")
	private String updateProgram;

	@Column(name="UPDATE_USER")
	private String updateUser;

	//bi-directional many-to-one association to AwserDetail
	@OneToMany(mappedBy="questionDetail")
	private List<AwserDetail> awserDetails;

	//bi-directional many-to-one association to QuestionBasic
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="QUESTION_ID")
	private QuestionBasic questionBasic;

	public QuestionDetail() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAwserCorrect() {
		return this.awserCorrect;
	}

	public void setAwserCorrect(String awserCorrect) {
		this.awserCorrect = awserCorrect;
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

	public String getIdReference() {
		return this.idReference;
	}

	public void setIdReference(String idReference) {
		this.idReference = idReference;
	}

	public String getQuestion() {
		return this.question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public int getQuesttionDetailCode() {
		return this.questtionDetailCode;
	}

	public void setQuesttionDetailCode(int questtionDetailCode) {
		this.questtionDetailCode = questtionDetailCode;
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

	public List<AwserDetail> getAwserDetails() {
		return this.awserDetails;
	}

	public void setAwserDetails(List<AwserDetail> awserDetails) {
		this.awserDetails = awserDetails;
	}

	public AwserDetail addAwserDetail(AwserDetail awserDetail) {
		getAwserDetails().add(awserDetail);
		awserDetail.setQuestionDetail(this);

		return awserDetail;
	}

	public AwserDetail removeAwserDetail(AwserDetail awserDetail) {
		getAwserDetails().remove(awserDetail);
		awserDetail.setQuestionDetail(null);

		return awserDetail;
	}

	public QuestionBasic getQuestionBasic() {
		return this.questionBasic;
	}

	public void setQuestionBasic(QuestionBasic questionBasic) {
		this.questionBasic = questionBasic;
	}

}