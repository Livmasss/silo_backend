package com.livmas.silo_web.data.services.impl;

import com.livmas.silo_web.data.entities.CatastropheEntity;
import com.livmas.silo_web.data.repositories.CatastropheRepository;
import com.livmas.silo_web.data.services.CatastropheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CatastropheServiceImpl implements CatastropheService {
    CatastropheRepository repository;
    @Autowired
    public CatastropheServiceImpl(
            CatastropheRepository repository
    ) {
        this.repository = repository;
    }

    @Override
    public CatastropheEntity getEntity() {
        return repository.findAll().get(0);
    }

    @Override
    public void deleteEntity(CatastropheEntity entity) {
        repository.delete(entity);
    }

    @Override
    public void saveEntity(CatastropheEntity entity) {
        repository.save(entity);
    }
}
