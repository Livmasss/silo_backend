package com.livmas.silo_web.data.services.impl;

import com.livmas.silo_web.data.entities.CatastropheEntity;
import com.livmas.silo_web.data.repositories.CatastropheRepository;
import com.livmas.silo_web.data.services.CatastropheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CatastropheServiceImpl
        extends BaseServiceImpl<CatastropheEntity, CatastropheRepository>
        implements CatastropheService {
    @Autowired
    public CatastropheServiceImpl(CatastropheRepository repository) {
        super(repository);
    }
}
