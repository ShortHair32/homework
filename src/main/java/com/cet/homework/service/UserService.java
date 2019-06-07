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
    public User getUser(int number) {
        return userRepository.findUser(number);
    }
    public User addUser(User u){
        userRepository.save(u);
        return userRepository.refresh(u);
    }
    public User updateUser(int uid, String newName){
        User u=userRepository.findById(uid).get();
        u.setName(newName);
        return userRepository.save(u);
    }
    public List<User> listusers(){
        return userRepository.listusers();
    }
}
