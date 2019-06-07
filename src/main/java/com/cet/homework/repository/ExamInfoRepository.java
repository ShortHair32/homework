package com.cet.homework.repository;

import com.cet.homework.entity.ExamInfo;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
//白
//监考信息持久化
@Repository
@Transactional
public class ExamInfoRepository {
    @PersistenceContext
    private EntityManager em;
    /**
     * 添加监考信息
     * @param examInfo
     * @return
     */
   public ExamInfo addExamInfo(ExamInfo examInfo){

       em.persist(examInfo);
       return examInfo;
   }

}
