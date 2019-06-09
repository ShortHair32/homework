package com.cet.homework.repository;

import com.cet.homework.entity.Homework;
import com.cet.homework.entity.HomeworkDetail;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface HomeworkDetailRepository extends CustomizedRepository<HomeworkDetail, Integer> {
    /*//根据任务id查找homework完成情况
    @Query("SELECT hd FROM HomeworkDetail hd WHERE hd.homework.id=:hid")
    HomeworkDetail findhomeworkdetailbyhomeworkid(@Param("hid") int hid);*/
    @Query("SELECT hd FROM HomeworkDetail hd")
    List <HomeworkDetail> listhomeworkdetails();
}
