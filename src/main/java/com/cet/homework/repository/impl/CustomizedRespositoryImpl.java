package com.cet.homework.repository.impl;

import com.cet.homework.repository.CustomizedRepository;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;

public class CustomizedRespositoryImpl<T, ID> extends SimpleJpaRepository<T, ID> implements CustomizedRepoistory<T, ID> {
    private EntityManager entityManager;

    public CustomizedRespositoryImpl(JpaEntityInformation entityInformation,
                                     EntityManager entityManager) {
        super(entityInformation, entityManager);
        this.entityManager = entityManager;
    }

    @Override
    public T refresh(T t) {
        entityManager.refresh(t);
        return t;
    }


}
