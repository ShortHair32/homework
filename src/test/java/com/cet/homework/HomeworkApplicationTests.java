package com.cet.homework;

import com.cet.homework.entity.Homework;
import com.cet.homework.entity.User;
import com.cet.homework.service.HomeworkService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HomeworkApplicationTests {
@Autowired
private HomeworkService homeworkservice;

    @Test
    public void contextLoads() {
    }
    @Test
    public void userdaotest(){
        User u=new User();
        u.setPhone("15546503308");
        u.setName("blake");
        u.setPassword("123456");
    }
    @Test
    public void hwtest(){
        User teacher=new User(666);
        Homework s=new Homework(997);
        s.setTeacher(teacher);
        Homework s2=new Homework(996);
        s.setTeacher(teacher);
        List<Homework> list= homeworkservice.listTeacherHomeworks(666);
        System.out.println("hwtest");
        list.toString();
    }
}
