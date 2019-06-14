package com.cet.homework.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class User {
    public static final int USER_AUTHORITY = 1;
    public static final int ADMIN_AUTHORITY = 2;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String phone;   /*手机号码*/
    private String name;    /*姓名*/
    private String detail; /*简介*/
    private String post;  /*职称*/
    @OneToMany(mappedBy = "teacher")
    List<Homework> homeworks;
    @OneToMany(mappedBy = "teacher")
    List<ExamInfo> examinfos;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    // 在没有声明时默认为1
    private int authority = 1;
    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP",
            updatable = false,
            insertable = false)
    private LocalDateTime insertTime;

    public User(int id) {
        this.id = id;
    }
}