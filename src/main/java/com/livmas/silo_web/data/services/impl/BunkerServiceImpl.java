package com.livmas.silo_web.data.services.impl;

import com.livmas.silo_web.data.entities.BunkerEntity;
import com.livmas.silo_web.data.repositories.BunkerRepository;
import com.livmas.silo_web.data.services.BunkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BunkerServiceImpl
        extends BaseServiceImpl<BunkerEntity, BunkerRepository>
        implements BunkerService {
    @Autowired
    protected BunkerServiceImpl(BunkerRepository repository) {
        super(repository);
    }
}
