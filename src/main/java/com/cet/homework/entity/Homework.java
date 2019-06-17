package com.cet.homework.entity;

import com.fasterxml.jackson.annotation.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.context.annotation.Lazy;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@JsonIdentityInfo(generator= ObjectIdGenerators.IntSequenceGenerator.class, property="@id")
public class Homework {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    public static final int ON = 1;
    public static final int OFF = 2;
    // 任务名称
    private String title;
    // 任务内容，普通长度可能不够
    @Column(columnDefinition = "TEXT")
    private String content;
    @ManyToOne
    private User teacher;
    @OneToOne(mappedBy = "homework")
    private HomeworkDetail homeworkDetail;
    //截止日期
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime deadLineTime;
    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP",
            updatable = false,
            insertable = false)
    private LocalDateTime insertTime;
    //默认创建即开始
    private int state=ON;
    public Homework(int id) {
        this.id = id;
    }
}
