package com.cet.homework.controller;
import com.cet.homework.entity.ExamInfo;
import com.cet.homework.entity.Homework;
import com.cet.homework.entity.User;
import com.cet.homework.service.ExamInfoService;
import com.cet.homework.service.HomeworkService;
import com.cet.homework.service.UserService;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
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
    //ok
    @PostMapping("/usermanagement")
    public Map postUser(@RequestBody User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()) );
        userservice.addUser(user);
        return Map.of("users", userservice.listusers());
    }
    //管理员注册
    //OK
    @PostMapping("/register")
    public void register(@RequestBody User user){
    user.setPassword(passwordEncoder.encode(user.getPassword()) );
    userservice.addUser(user);
    }
    //管理员修改指定用户信息
    //也能改变人员权限
    //service层用了save，即相当于更新
    //ok
    @PostMapping("/modify")
    public void modify(@RequestBody User u){
        u.setPassword(passwordEncoder.encode(u.getPassword()) );
        User u1=new User();
        u1.setId(userservice.getUser(u.getPhone()).getId());
        u1.setPassword(u.getPassword());
        u1.setAuthority(u.getAuthority());
        u1.setName(u.getName());
        u1.setPhone(u.getPhone());
        u1.setDetail(u.getDetail());
        u1.setPost(u.getPost());
        userservice.addUser(u1);
    }
    //删除管理员（是将其权限降级还是删除这个人？）
    //根据手机号找到用户，再根据ID删除用户
    //用户和管理员都能删除
    //??
    @PostMapping("/removeadmin")
    public void removeadmin(@RequestBody User user){
        userservice.removeUser(userservice.getUser(user.getPhone()).getId());
    }
    //关闭任务
    //??
    @PostMapping("/closehomework")

    public void closehomework(@RequestBody Homework homework){
        homeworkService.close(homework.getId());
    }
    //创建任务
    //ok
    @PostMapping("/addhomework")
    public void addhomework(@RequestBody Homework homework){
        homeworkService.addHomework(homework);
    }
    //修改任务
    //ok
    @PostMapping("/modifyhomework")
    public void modifyhomework(@RequestBody Homework homework){
        homeworkService.modify(homework.getId(),homework);
    }
    //添加考试信息
    //ok
    @PostMapping("/ExamInfo")
    public Map postExamInfo(@RequestBody ExamInfo examInfo){
        examInfoService.addExamInfo(examInfo);
        return Map.of("examInfo",examInfoService.listexamInfos());
    }
    //重新分配教师,分配都是它
    //ok
    @PostMapping("/ExamInfo/updateteacher")
    public void updateTeacher(@RequestBody ExamInfo examInfo){
        examInfoService.updateExamInfo(examInfo);
    }
    //查找所有考试信息
    @GetMapping("/ExamInfo/findExamInfo")
    @ResponseBody
    public Map findExamInfo() {
        return Map.of("examInfo",examInfoService.listexamInfos());
    }
    //根据教室查找考试信息
    @PostMapping("/ExamInfo/getExamInfo")
    public Map getExamInfo(@RequestBody ExamInfo examInfo) {
        return Map.of("examInfo",examInfoService.getExamInfo(examInfo.getClassRoom()));
    }

}
