package com.livmas.silo_web.data.services.impl;

import com.livmas.silo_web.data.repositories.BaseRepository;
import com.livmas.silo_web.data.services.BaseService;

import java.util.List;
import java.util.Optional;

public abstract class BaseServiceImpl<E, R extends BaseRepository<E>> implements BaseService<E> {
    R repository;
    protected BaseServiceImpl(
            R repository
    ) {
        this.repository = repository;
    }

    @Override
    public E getEntity() {
        return repository.getRandom(1).get(0);
    }

    @Override
    public List<E> getEntities(int rowsCount) {
        return repository.getRandom(rowsCount);
    }

    @Override
    public Optional<E> getById(Long id) {
        return repository.findById(id);
    }
}
