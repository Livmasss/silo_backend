package com.livmas.silo_web.data.services.impl;

import com.livmas.silo_web.data.entities.HealthEntity;
import com.livmas.silo_web.data.repositories.HealthRepository;
import com.livmas.silo_web.data.services.HealthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HealthServiceImpl
        extends BaseServiceImpl<HealthEntity, HealthRepository>
        implements HealthService {
    @Autowired
    public HealthServiceImpl(HealthRepository repository) {
        super(repository);
    }
}
