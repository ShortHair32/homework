package com.cet.homework;

import com.cet.homework.entity.User;
import com.cet.homework.repository.HomeworkRepository;
import com.cet.homework.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HomeworkApplicationTests {
    private EntityManager em;
    @Autowired
    private UserRepository userdao;
    @Autowired
    private HomeworkRepository homeworkRepository;

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
//    @Test
//    public void homeworktest(){
//        User tc=new User(4310);
//        tc.setName("终南山");
//        Homework h1=new Homework(996);
//        h1.setTitle("h1");
//        Homework h2=new Homework(997);
//        h2.setTitle("h2");
//        h1.setTeacher(tc);
//        h2.setTeacher(tc);
//        userdao.save(tc);
//        homeworkRepository.save(h1);
//        homeworkRepository.save(h2);
//    }

}
