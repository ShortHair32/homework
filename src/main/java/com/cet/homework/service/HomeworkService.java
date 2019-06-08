package com.cet.homework.service;

import com.cet.homework.entity.Homework;
import com.cet.homework.repository.HomeworkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class HomeworkService {
    @Autowired
    private HomeworkRepository homeworkRepository;

    public Homework addHomework(Homework homework) {
        homeworkRepository.save(homework);
        return homeworkRepository.refresh(homework);
    }
    public List<Homework> listTeacherHomeworks(int tid) {
        return homeworkRepository.list(tid);
    }

}
