package com.cet.homework.repository;

import com.cet.homework.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
//王嘉奇
//就两个查询方法
@Repository
@Transactional
public interface UserRepository extends CustomizedRepository<User, Integer>{
    //根据手机号查找用户
    @Query("SELECT u FROM User u WHERE u.phone=:phone")
    public User findUser(@Param("phone") String phone);
    //列出所有用户
    @Query("SELECT u FROM User u")
    public List<User> listusers();
}