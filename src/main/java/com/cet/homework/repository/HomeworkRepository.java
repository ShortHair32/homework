package com.cet.homework.repository;

import com.cet.homework.entity.Homework;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface HomeworkRepository extends CustomizedRepository<Homework, Integer> {
    /*
    根据老师ID查找homework
     */

    @Query("SELECT h FROM Homework h WHERE h.teacher.id=:tid ")
    List<Homework> list(@Param("tid") int tid);

}
