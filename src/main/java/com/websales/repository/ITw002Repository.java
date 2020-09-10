package com.websales.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.websales.entity.AwserDetail;
import com.websales.entity.HistoryExamBasic;

@Repository
public interface ITw002Repository extends JpaRepository<HistoryExamBasic, String> {

	@Query(value = "SELECT QUESTION_DETAIL_ID AS QID, QUESTION, AWSER_DETAIL_CD_1 AS answerCD1,"
			+ " AWSER_DETAIL_NAME_1 AS ansertName1, question.type, AWSER_DETAIL_CD_2 AS answerCD2, AWSER_DETAIL_NAME_2 AS ansertName2,"
			+ " basic.id AS basicID, subject.NAME, basic.TIME_OVER_EXAM, answer.ID as answerID, subject.ID"
			+ " FROM awser_detail answer"
			+ " INNER JOIN QUESTION_DETAIL question ON answer.QUESTION_DETAIL_ID = question.ID"
			+ " INNER JOIN question_basic basic on question.QUESTION_ID = basic.ID"
			+ " INNER JOIN subject on basic.SUBJECT_ID = subject.id", nativeQuery = true)
	public List<Object[]> getQuestion();

	@Query(value = "SELECT QUESTION_DETAIL_ID AS QID, QUESTION, AWSER_DETAIL_CD_1 AS answerCD1,"
			+ " AWSER_DETAIL_NAME_1 AS ansertName1, question.type, AWSER_DETAIL_CD_2 AS answerCD2, AWSER_DETAIL_NAME_2 AS ansertName2,"
			+ " basic.id AS basicID, subject.NAME, basic.TIME_OVER_EXAM, answer.ID as answerID, subject.ID, question.QUESTTION_DETAIL_CODE"
			+ " FROM awser_detail answer"
			+ " INNER JOIN QUESTION_DETAIL question ON answer.QUESTION_DETAIL_ID = question.ID"
			+ " INNER JOIN question_basic basic on question.QUESTION_ID = basic.ID"
			+ " INNER JOIN subject on basic.SUBJECT_ID = subject.id"
			+ " WHERE question.QUESTION_ID = :numExam AND basic.TYPE = :type"
			+ " ORDER BY question.QUESTTION_DETAIL_CODE", nativeQuery = true)
	public List<Object[]> getQuestion(@Param("numExam") String numExam, @Param("type") String type);
	
	@Query(value="SELECT basic.ID as question_id, question.type as question_type,"
			+ " question.ID as question_detail_id, question.AWSER_CORRECT as question_result"
			+ " FROM QUESTION_DETAIL question"
			+ " INNER JOIN question_basic basic ON question.QUESTION_ID = basic.ID"
			+ " INNER JOIN subject ON basic.SUBJECT_ID = subject.id"
			+ " WHERE question.QUESTION_ID = :numExam", nativeQuery = true)
	public List<Object[]> getQuestionForCheckResultByExamCode(@Param("numExam") String numExam);
}
