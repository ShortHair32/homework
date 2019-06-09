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
    @Query("SELECT e FROM ExamInfo e WHERE e.classRoom=:classRoom")
    ExamInfo findExamInfo(@Param("classRoom") String classRoom);
    //列出所有监考信息
    @Query("SELECT e FROM ExamInfo e")
    List<ExamInfo> listexamInfos();
    //根据教师查询有几个监考任务
    @Query("SELECT COUNT(id) FROM ExamInfo e WHERE e.teacher.id=:tid")
    int count (@Param("tid") int tid);
    //查询教师分配给自己的监考任务（通知短信）
    @Query("SELECT e FROM ExamInfo e WHERE e.teacher.id=:tid")
    List<ExamInfo> queryownexaminfo(@Param("tid") int tid);
}
