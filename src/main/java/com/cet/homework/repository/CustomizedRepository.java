package com.cet.homework.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@NoRepositoryBean
public interface CustomizedRepository<T, ID> extends JpaRepository<T, ID> {
    T refresh(T t);
}