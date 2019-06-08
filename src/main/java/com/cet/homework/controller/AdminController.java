package com.cet.homework.controller;
import com.cet.homework.entity.ExamInfo;
import com.cet.homework.entity.User;
import com.cet.homework.service.ExamInfoService;
import com.cet.homework.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
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
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private ExamInfoService examInfoService;
    /**
     * 添加用户，并返回所有用户信息
     */
    @PostMapping("/usermanagement")
    public Map postUser(@RequestBody User user) {
        userservice.addUser(user);
        return Map.of("users", userservice.listusers());
    }
    //注册
    @PostMapping("/register")
    public void register(@RequestBody User user){
    user.setPassword(passwordEncoder.encode(user.getPassword()) );
    userservice.addUser(user);
    }
    //添加考试信息
    @PostMapping("/ExamInfo")
    public Map postExamInfo(@RequestBody ExamInfo examInfo){
        examInfoService.addExamInfo(examInfo);
        return Map.of("examInfo",examInfoService.listexamInfos());
    }
    //重新分配教师
    @PostMapping("/ExamInfo/updateteacher")
    public void updateTeacher(@RequestBody ExamInfo examInfo){
        examInfoService.updateExamInfo(examInfo);
    }
    //查找考试信息
    @PostMapping("/ExamInfo/findExamInfo")
    public Map findExamInfo(){
        return Map.of("ExamInfo",examInfoService.listexamInfos());
    }
    //根据班级查找考试信息
    @PostMapping("/ExamInfo/getExamInfo")
    public ExamInfo getExamInfo(String classroom){
        return examInfoService.getExamInfo(classroom);
    }
}
