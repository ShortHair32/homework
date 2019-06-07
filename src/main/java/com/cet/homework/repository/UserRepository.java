package com.cet.homework.repository;

import com.cet.homework.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
@Repository
@Transactional
public class UserRepository {
    @PersistenceContext
    private EntityManager em;
    /**
     * 添加用户，并返回包括数据库时间戳的用户对象
     * @param user
     * @return
     */
    public User addUser(User user) {
        em.persist(user);
        return null;
    }
    /**
     * 更新指定ID用户的姓名（就先姓名，应该是所有信息都能改）
     * @param uid
     * @param newName
     * @return
     */
    public void updateUser(int uid, String newName) {
        User u=new User();
        u.setId(uid);
        em.merge(u);
        em.refresh(u);
        u.setName(newName);
    }
    //根据id查找用户
    public User findUser(int uid){
        return em.find(User.class, uid);
    }

}