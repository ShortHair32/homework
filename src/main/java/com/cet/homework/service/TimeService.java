package com.cet.homework.service;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.cet.homework.entity.ExamInfo;
import com.cet.homework.repository.ExamInfoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.List;

@Slf4j
@Component
public class TimeService {
    @Autowired
    private ExamInfoRepository examInfoRepository;
    //@Scheduled(cron="0 0 8 * * *")
    @Scheduled(cron="*/10 * * * * *")
    public void MyTimer(){
//查询第二天的考试信息
        LocalDateTime now=LocalDateTime.now();
        List<ExamInfo> examInfos=examInfoRepository.listexamInfos();
        examInfos.forEach(i->{
            if(i.getBeginTime().isAfter(now));
            System.out.println(i.getTeacher().getName()+i.getBeginTime()+"有监考");
        });
    }
}
