package com.cet.homework;

import com.cet.homework.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HomeworkApplicationTests {

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
}
