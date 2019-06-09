package com.cet.homework.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class TimeService {
    @Scheduled(cron="0 0 8 * * *")
    public void MyTimer(){
        System.out.println("定时器打印明天的任务完成");

    }
}
