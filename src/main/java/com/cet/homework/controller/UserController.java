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
    @GetMapping("/allhomework")
    public Map getMain(){
        List<Homework> homework = null;
            homework = homeworkService.listhomeworks();
        return Map.of("homework", homework);
    }
    //用户修改自己的信息,在前端控制id无法更改，默认为当前用户id
    @PostMapping("/modify")
    public void modify(@RequestBody User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()) );
        userService.addUser(user);
    }
    //列出自己的任务
    @GetMapping("/myhomework")
    public Map myhomework(@RequestAttribute int uid){
        List<Homework> homework = null;
        homework = homeworkService.findHomeworkbyuid(uid);
        return Map.of("homework", homework);
    }
    //完成任务
    @PostMapping("/domyhomework")
    public void domyhomework(@RequestBody HomeworkDetail homeworkDetail,@RequestAttribute int hid){
        homeworkService.completehomework(homeworkDetail);
    }
}
