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
    //根据用户ID查找homework
    @Query("SELECT h FROM Homework h WHERE h.user.id=:uid ")
    List<Homework> findHomeworkbyuid(@Param("uid") int uid);
    //列出所有任务
    @Query("SELECT h FROM Homework ")
    List<Homework> listhomeworks();
    //根据任务id查找homework
    @Query("SELECT h FROM Homework h WHERE h.id=:hid ")
    Homework findHomeworkbyhid(@Param("hid") int hid);
}
