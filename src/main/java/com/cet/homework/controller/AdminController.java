package com.cet.homework.controller;
import com.cet.homework.entity.ExamInfo;
import com.cet.homework.entity.Homework;
import com.cet.homework.entity.User;
import com.cet.homework.service.ExamInfoService;
import com.cet.homework.service.HomeworkService;
import com.cet.homework.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.*;

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
    private HomeworkService homeworkService;
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
    //管理员注册
    @PostMapping("/register")
    public void register(@RequestBody User user){
    user.setPassword(passwordEncoder.encode(user.getPassword()) );
    userservice.addUser(user);
    }
    //管理员修改指定用户信息
    //也能改变人员权限
    //service层用了save，即相当于更新
    @PostMapping("/modify")
    public void modify(@RequestBody User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()) );
        userservice.addUser(user);
    }
    //删除管理员（是将其权限降级还是删除这个人？）
    //根据手机号找到用户，再根据ID删除用户
    //用户和管理员都能删除
    @PostMapping("/removeadmin")
    public void removeadmin(@RequestAttribute String phone){
        userservice.removeUser(userservice.getUser(phone).getId());
    }
    //关闭任务
    @PostMapping("/closehomework")
    public void closehomework(@RequestAttribute int id){
        homeworkService.close(id);
    }
    //创建任务
    @PostMapping("/addhomework")
    public void addhomework(@RequestBody Homework homework){
        homeworkService.addHomework(homework);
    }
    //修改任务
    @PostMapping("/modifyhomework")
    public void modifyhomework(@RequestBody Homework homework){
        homeworkService.addHomework(homework);
    }
    //添加考试信息
    @PostMapping("/ExamInfo")
    public Map postExamInfo(@RequestBody ExamInfo examInfo){
        examInfoService.addExamInfo(examInfo);
        return Map.of("examInfo",examInfoService.listexamInfos());
    }
    //重新分配教师,分配都是它
    @PostMapping("/ExamInfo/updateteacher")
    public Map updateTeacher(@RequestBody ExamInfo examInfo){
        examInfoService.updateExamInfo(examInfo);
        return Map.of("teachers", userservice.listteachers());
    }
    //查找考试信息
    @PostMapping("/ExamInfo/findExamInfo")
    public Map findExamInfo() {
        return Map.of("ExamInfo", examInfoService.listexamInfos());
    }
    //根据班级查找考试信息
    @PostMapping("/ExamInfo/getExamInfo")
    public ExamInfo getExamInfo(String classroom) {
        return examInfoService.getExamInfo(classroom);
    }


}
