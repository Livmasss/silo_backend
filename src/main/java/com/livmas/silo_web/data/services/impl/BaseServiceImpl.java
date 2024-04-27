package com.livmas.silo_web.data.services.impl;

import com.livmas.silo_web.data.services.BaseService;
import org.springframework.data.jpa.repository.JpaRepository;

public class BaseServiceImpl<E, R extends JpaRepository<E, Long>> implements BaseService<E> {
    R repository;
    public BaseServiceImpl(
            R repository
    ) {
        this.repository = repository;
    }

    @Override
    public E getEntity() {
        return repository.findAll().get(0);
    }
}
