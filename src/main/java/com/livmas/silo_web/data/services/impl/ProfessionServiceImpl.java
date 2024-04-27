package com.livmas.silo_web.data.services.impl;

import com.livmas.silo_web.data.entities.ProfessionEntity;
import com.livmas.silo_web.data.repositories.ProfessionRepository;
import com.livmas.silo_web.data.services.ProfessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfessionServiceImpl
        extends BaseServiceImpl<ProfessionEntity, ProfessionRepository>
        implements ProfessionService {
    @Autowired
    public ProfessionServiceImpl(ProfessionRepository repository) {
        super(repository);
    }
}
