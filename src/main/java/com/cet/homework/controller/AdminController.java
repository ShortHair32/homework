package com.cet.homework.controller;
import com.cet.homework.entity.ExamInfo;
import com.cet.homework.entity.User;
import com.cet.homework.service.ExamInfoService;
import com.cet.homework.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


//王嘉奇
@Slf4j
@RestController
@RequestMapping("/api/admin")
@Transactional
public class AdminController {
    @Autowired
    private UserService userservice;
    private ExamInfoService examInfoService;
    /**
     * 添加用户，并返回所有用户信息
     */
    @PostMapping("/usermanagement")
    public Map postUser(@RequestBody User user) {
        userservice.addUser(user);
        return Map.of("users", userservice.listusers());
    }

    @PostMapping("/ExamInfo")
    public Map postExamInfo(@RequestBody ExamInfo examInfo,@RequestAttribute int status){
        examInfoService.addExamInfo(examInfo);
        return Map.of("examInfo",examInfoService.listexamInfo(status));
    }

    @PostMapping("/ExamInfo/updateteacher")
    public void updateTeacher(@RequestBody ExamInfo examInfo){
        examInfoService.updateExamInfo(examInfo);
    }

}
