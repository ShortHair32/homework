package com.cet.homework.repository;

import com.cet.homework.entity.ExamInfo;
import com.cet.homework.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

//监考信息持久化
@Repository
@Transactional
public interface ExamInfoRepository extends JpaRepository<ExamInfo, Integer> {
    /**
     * 获取指定ID的监考信息
     * @param id
     * @return
     */
    @Query("SELECT e FROM ExamInfo e WHERE e.id=:id")
    ExamInfo find(@Param("id") int id);

}
