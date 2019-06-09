package com.cet.homework.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class HomeworkDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    //解决情况
    @Column(columnDefinition = "TEXT")
    private String solution;
    @ManyToOne(fetch = FetchType.LAZY)
    private User student;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(unique=true)
    private Homework homework;
    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP",
            updatable = false, insertable = false)
    private LocalDateTime completeTime;
}
