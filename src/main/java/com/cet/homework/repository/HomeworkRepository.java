package com.cet.homework.repository;

import com.cet.homework.entity.Homework;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
//石
//1方法创建
@Repository
public interface HomeworkRepository extends CustomizedRepository<Homework, Integer> {
    @Query("SELECT h FROM Homework h WHERE h.examinfo.id=:cid AND h.examinfo.teacher.id=:tid")
    List<Homework> list(@Param("cid") int cid, @Param("tid") int tid);

}
