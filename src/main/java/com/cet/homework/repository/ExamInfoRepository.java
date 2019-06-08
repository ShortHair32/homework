package com.cet.homework.repository;

import com.cet.homework.entity.ExamInfo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


//白
//监考信息持久化
@Repository
@Transactional
public interface ExamInfoRepository extends CustomizedRepository<ExamInfo, Integer>{


    /**
     *根据教室查找考试信息
     */
    @Query("SELECT e FROM ExamInfo e WHERE e.status=:status")
    List<ExamInfo> listexamInfos(@Param("status") int status);
    @Query("SELECT e FROM ExamInfo e WHERE e.classRoom=:classRoom")
    ExamInfo findExamInfo(@Param("classRoom") String classRoom);
}
