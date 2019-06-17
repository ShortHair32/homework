package com.cet.homework.controller;


import com.cet.homework.entity.ExamInfo;
import com.cet.homework.entity.Homework;
import com.cet.homework.entity.HomeworkDetail;
import com.cet.homework.entity.User;
import com.cet.homework.service.ExamInfoService;
import com.cet.homework.service.HomeworkService;
import com.cet.homework.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private ExamInfoService examInfoService;
    @Autowired
    private HomeworkService homeworkService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    /**
            * 列出全部任务
     */
    //??
    @GetMapping("/allhomework")
    public Map getMain(){
        List<Homework> homework = null;
            homework = homeworkService.listhomeworks();
        return Map.of("homework", homework);
    }
    //用户修改自己的信息,在前端控制id无法更改，默认为当前用户id
    @PostMapping("/usermodify")
    public void usermodify(@RequestBody User u){
        u.setPassword(passwordEncoder.encode(u.getPassword()) );
        User u1=new User();
        u1.setId(userService.getUser(u.getPhone()).getId());
        u1.setPassword(u.getPassword());
        u1.setAuthority(u.getAuthority());
        u1.setName(u.getName());
        u1.setPhone(u.getPhone());
        u1.setDetail(u.getDetail());
        u1.setPost(u.getPost());
        userService.addUser(u1);
    }
    //列出自己的任务
    @GetMapping("/myhomework")
    public Map myhomework(@RequestBody User u){
        List<Homework> homework = null;
        homework = homeworkService.findHomeworkbyuid(u.getId());
        return Map.of("homework", homework);
    }
    //完成任务
    @PostMapping("/domyhomework")
    public void domyhomework(@RequestBody HomeworkDetail homeworkDetail){
        homeworkService.completehomework(homeworkDetail);
    }
    //列出自己的监考任务
    @GetMapping("/myexaminfo")
    public Map myexaminfo(@RequestBody User u){
        List<ExamInfo> examInfos=null;
        examInfos=examInfoService.queryownexaminfo(u.getId());
        return Map.of("examinfos", examInfos);
    }
}
