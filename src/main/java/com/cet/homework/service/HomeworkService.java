package com.cet.homework.service;

import com.cet.homework.entity.Homework;
import com.cet.homework.entity.HomeworkDetail;
import com.cet.homework.repository.HomeworkDetailRepository;
import com.cet.homework.repository.HomeworkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class HomeworkService {
    @Autowired
    public HomeworkRepository homeworkRepository;

    @Autowired
    private HomeworkDetailRepository homeworkDetailRepository;
    //创建（发布）、也能修改
    public Homework addHomework(Homework homework) {
        homeworkRepository.save(homework);
        return homeworkRepository.refresh(homework);
    }

    //列出所有任务
    public List<Homework> listhomeworks() {
        return homeworkRepository.listhomeworks();
    }

    //根据老师ID查找homework
    public List<Homework> findHomeworkbyuid(int uid) {
        return homeworkRepository.findHomeworkbyuid(uid);
    }

    //关闭任务,根据任务id查
    public void close(int hid) {
        Homework h = homeworkRepository.findHomeworkbyhid(hid);

        h.setState(Homework.OFF);
        homeworkRepository.save(h);
    }

    //根据任务id查找该任务完成情况
    public HomeworkDetail findhomeworkdetailbyhomeworkid(int hid) {
        return homeworkRepository.findhomeworkdetailbyhomeworkid(hid);
    }

    //完成任务
    public HomeworkDetail completehomework(HomeworkDetail homeworkDetail) {
        homeworkDetailRepository.save(homeworkDetail);
        return homeworkDetailRepository.refresh(homeworkDetail);
    }

    //列出所有已完成任务的回复信息
    public List<HomeworkDetail> listallhomeworkdetails() {
        return homeworkDetailRepository.listhomeworkdetails();
    }
    //根据标题查找任务
    public Homework Findhomeworkbytitle(String title){
        return homeworkRepository.findhomeworkbytitle(title);
    }
    //修改任务
    public Homework modify(int id,Homework u){
        Homework u1=homeworkRepository.findById(id).get();
        u1.setTitle(u.getTitle());
        u1.setContent(u.getContent());
        u1.setDeadLineTime(u.getDeadLineTime());
        return homeworkRepository.save(u1);
    }
}
