package com.cet.homework;

import com.cet.homework.entity.Homework;
import com.cet.homework.entity.User;
import com.cet.homework.repository.HomeworkRepository;
import com.cet.homework.repository.UserRepository;
import com.cet.homework.service.HomeworkService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HomeworkApplicationTests {
    private EntityManager em;
    @Autowired
    private UserRepository userdao;
    @Autowired
    private HomeworkRepository homeworkRepository;
    @Autowired
    private HomeworkService homeworkService;
    @Test
    public void contextLoads() {
    }
    @Test
    public void userdaotest(){
        User u=new User();
        u.setPhone("15546503308");
        u.setName("blake");
        u.setPassword("123456");
        userdao.save(u);
    }
    @Test
    public void homeworktest(){
        User tc=new User(4310);
        Homework h1=new Homework(996);
        Homework h2=new Homework(997);
        userdao.save(tc);
        homeworkRepository.save(h1);
        homeworkRepository.save(h2);
        h1.setTeacher(tc);
        //h2.setTeacher(tc);
        //List list=homeworkService.listTeacherHomeworks(4310);
        //list.toString();
    }

}
