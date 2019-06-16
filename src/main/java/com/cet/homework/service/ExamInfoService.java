package com.cet.homework.service;

import com.cet.homework.entity.ExamInfo;
import com.cet.homework.repository.ExamInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

//白
@Service
@Transactional
public class ExamInfoService {
    @Autowired
    private ExamInfoRepository examInfoRepository;
    //add方法
    public ExamInfo addExamInfo(ExamInfo e){
        examInfoRepository.save(e);
        return examInfoRepository.refresh(e);
    }
    //分配、重新分配教师
    public ExamInfo updateExamInfo(ExamInfo examInfo) {
        ExamInfo e=examInfoRepository.findById(examInfo.getId()).get();
        e.setTeacher(examInfo.getTeacher());
        e.setStatus(2);
        return examInfoRepository.save(e);
    }

    public  ExamInfo getExamInfo(String classroom){return examInfoRepository.findExamInfo(classroom);}
    public List<ExamInfo> listexamInfos(){
        return examInfoRepository.listexamInfos();
    }
    //查询某个教师有多少监考任务
    public int count(int tid){
        return examInfoRepository.count(tid);
    }
    //通知短信
    public List<ExamInfo> queryownexaminfo(int tid){
        return examInfoRepository.queryownexaminfo(tid);
    }
}
