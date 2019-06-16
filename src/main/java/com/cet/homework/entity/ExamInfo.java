package com.cet.homework.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
//白欣宇 实体类考试信息
@Getter
@Setter
@NoArgsConstructor
@Entity
public class ExamInfo {
    public static final int NOT_ALLOCATED = 1;
    public static final int ALLOCATED = 2;
    public static final int FINISH = 3;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime beginTime;   /*起始时间*/
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime endTime;    /*结束时间*/
    private String classRoom;         /*地点*/
    private String className; /*课程*/
    // 在没有声明时默认为1
    private int needCount =1 ;  /*所需人数*/
    //在没有声明时默认为 1
    private int status =1;  /*监考信息状态*/
    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP",
            updatable = false,
            insertable = false)
    private LocalDateTime insertTime;
    @ManyToOne(fetch = FetchType.EAGER)
    private User teacher;
    @OneToOne(mappedBy = "examInfo")
    private ExamInfoDetail examInfoDetail;
    public ExamInfo(int id) {
        this.id= id;
    }
    public ExamInfo(String classroom) {
        this.classRoom= classroom;
    }
}
