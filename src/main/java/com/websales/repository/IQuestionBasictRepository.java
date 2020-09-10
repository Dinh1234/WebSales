package com.websales.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.websales.entity.QuestionBasic;

public interface IQuestionBasictRepository extends JpaRepository<QuestionBasic, String> {

	@Query(value = " SELECT " + "   qb.id," + "   qb.subject_Id," + "   IFNULL(qb.content,'')," + "   qb.type,"
			+ "   qb.time_start_exam," + "   qb.time_end_exam," + "   qb.TIME_OVER_EXAM," + "   qb.score,"
			+ "   COUNT(heb.id) countExam," + "   qb.CREATE_USER" +
			// "'0' as highestScore " +
			"   ,ct.value" + "   ,ct.value_en" + " FROM " + "     teamwork.question_basic qb " + "         LEFT JOIN "
			+ "     teamwork.question_detail qd ON qb.id = qd.question_id " + "         LEFT JOIN "
			+ "     history_exam_basic heb ON qb.id = heb.question_basic_id "
			+ "         LEFT JOIN CATEGORY ct ON ct.id = 'LBT' AND ct.key = qb.type " + " WHERE "
			+ "     (:subjectType = '' OR qb.subject_Id = :subjectType) "
			+ " 	AND (:questionType = '' OR :questionType = qb.type) "
			+ " 	AND (:questionBasicId = '' OR :questionBasicId = qb.id) "
			+ " GROUP BY qd.question_id , qb.id ", nativeQuery = true)
	public Page<Object[]> getListTest(@Param("subjectType") String subjectType,
			@Param("questionType") String questionType, @Param("questionBasicId") String questionBasicId,
			Pageable pageable);

	@Query(value = "SELECT QB FROM QuestionBasic QB WHERE QB.subject.id = :subjectType AND QB.type = :questionType AND QB.id = :questionBasicId AND QB.delFlag = '0'")
	public QuestionBasic getQuestionBasicByIdAndSubJectAndType(@Param("subjectType") String subjectType,
			@Param("questionType") String questionType, @Param("questionBasicId") String questionBasicId);

	@Override
	public QuestionBasic save(QuestionBasic entity);

	@Query(value = "SELECT ex.ID, ex.CONTENT FROM teamwork.question_basic ex WHERE "
			+ "(ex.CREATE_USER = :userId OR ex.UPDATE_USER = :userId) "
			+ "ORDER BY ex.CREATE_DATE, ex.UPDATE_DATE", nativeQuery = true)
	public List<Object[]> getListExamTitle(@Param("userId") String userId);
}
