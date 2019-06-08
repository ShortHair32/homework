package com.cet.homework.service;

import com.cet.homework.entity.ExamInfo;
import com.cet.homework.repository.ExamInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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
}
