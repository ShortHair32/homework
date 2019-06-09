package com.cet.homework.controller;


import com.cet.homework.entity.ExamInfo;
import com.cet.homework.entity.Homework;
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
     * 仅主页面时，加载全部课程
     * @param uid
     * @param aid
     * @return
     */
    @GetMapping("/main")
    public Map getMain(@RequestAttribute int uid, @RequestAttribute int aid) {
        List<Homework> homework = null;
            homework = homeworkService.listTeacherHomeworks(uid);
        return Map.of("homework", homework);
    }
    //用户修改自己的信息,在前端控制id无法更改，默认为当前用户id
    @PostMapping("/modify")
    public void modify(@RequestBody User user){
        user.setPassword(passwordEncoder.encode(user.getPassword()) );
        userService.addUser(user);
    }
}
