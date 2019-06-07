package com.cet.homework.repository;

import com.cet.homework.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
//王嘉奇
//就两个查询方法
@Repository

public interface UserRepository extends CustomizedRepository<User, Integer>{
    //根据id查找用户
    @Query("SELECT u FROM User u WHERE u.id=:id")
    public User findUser(@Param("id") int id);
    //列出所有用户
    @Query("SELECT u FROM User u")
    public List<User> listusers();
}