package com.cet.homework.service;

import com.cet.homework.entity.User;
import com.cet.homework.repository.UserRepository;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//王嘉奇
//除了两个查询，新增一个add一个update方法
@Service
@Transactional
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public User getUser(String number) {
        return userRepository.findUser(number);
    }
    //既能创建也能修改，万能SAVE
    public User addUser(User u){
        return userRepository.save(u);
    }
    //删除指定用户
    public void removeUser(int uid){
        userRepository.deleteById(uid);
    }
    //列出所有用户
    public List<User> listusers(){
        return userRepository.listusers();
    }
    //列出所有教师
    public List<User> listteachers(){
        return userRepository.listteachers();
    }
}
