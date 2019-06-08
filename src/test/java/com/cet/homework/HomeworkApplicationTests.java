package com.cet.homework;

import com.cet.homework.entity.User;
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
}
