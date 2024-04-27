package com.livmas.silo_web.data.services;

import com.livmas.silo_web.data.entities.CatastropheEntity;

public interface CatastropheService {
    CatastropheEntity getEntity();

    void deleteEntity(CatastropheEntity entity);
    void saveEntity(CatastropheEntity entity);
}
