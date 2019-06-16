package com.cet.homework.service;

import com.cet.homework.entity.ExamInfo;
import com.cet.homework.repository.ExamInfoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class TimeService {
    @Autowired
    private ExamInfoRepository examInfoRepository;
    //@Scheduled(cron="0 0 8 * * *")
    @Scheduled(cron="2 * * * * ?")
    public void MyTimer(){

        for(ExamInfo e:examInfoRepository.querytomorrowexaminfo()){
            System.out.println("您明天"+e.getBeginTime()+"有监考任务");

        }


    }
}
