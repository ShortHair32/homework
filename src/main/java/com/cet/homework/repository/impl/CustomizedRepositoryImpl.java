package com.cet.homework.repository.impl;

import com.cet.homework.repository.CustomizedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

public class CustomizedRepositoryImpl<T, ID> extends SimpleJpaRepository<T, ID> implements CustomizedRepository<T, ID> {
    private EntityManager entityManager;
    public CustomizedRepositoryImpl(JpaEntityInformation entityInformation,EntityManager entityManager) {
        super(entityInformation, entityManager);
        this.entityManager = entityManager;
    }

    @Override
    public T refresh(T t) {
        entityManager.refresh(t);
        return t;
    }


}
