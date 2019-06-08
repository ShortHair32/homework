package com.cet.homework;

import ch.qos.logback.classic.Logger;
import com.cet.homework.entity.User;
import com.cet.homework.repository.UserRepository;
import com.cet.homework.service.UserService;
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
    private UserService userservice;
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
    public void userservicetest(){
        User u=userservice.getUser("15546503308");
        System.out.println(u.getName());
    }
}
