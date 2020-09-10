package com.websales.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.websales.entity.HistoryExamBasic;

public interface IHistoryExamBasictRepository extends JpaRepository<HistoryExamBasic, String> {

	@Query(value = 
			"  SELECT    " +
			"  	HB.ID,    " +
			"      HB.USER_EXAM_ID,    " +
			"      (SELECT NAME FROM APP_USER WHERE USER_NAME = HB.USER_EXAM_ID),    " +
			"      HB.QUESTION_BASIC_ID,    " +
			"      COUNT(QD.ID),    " +
			"      (SELECT COUNT(*) FROM HISTORY_EXAM_DETAIL HD WHERE HB.ID = HD.HISTORY_EXAM_BASIC_ID AND HD.ANSWER_RESULT = HD.QUESTION_RESULT ) TOTALCORRECT,    " +
			"      HB.TIME_START_EXAM,    " +
			"      HB.TIME_WORK_EXAM    " +
			"  FROM    " +
			"      HISTORY_EXAM_BASIC HB    " +
			"          LEFT JOIN QUESTION_DETAIL QD ON (QD.QUESTION_ID = HB.QUESTION_BASIC_ID)    " +
			"  WHERE    " +
			"      QUESTION_BASIC_ID = :questionBasicId    " +
			"      GROUP BY HB.ID    " +
			"       ORDER BY HB.UPDATE_DATE    "
			, nativeQuery = true)
	public List<Object[]> getListTestById(@Param("questionBasicId") String questionBasicId);
}