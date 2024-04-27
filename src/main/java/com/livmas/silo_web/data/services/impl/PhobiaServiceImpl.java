package com.livmas.silo_web.data.services.impl;

import com.livmas.silo_web.data.entities.PhobiaEntity;
import com.livmas.silo_web.data.repositories.PhobiaRepository;
import com.livmas.silo_web.data.services.PhobiaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PhobiaServiceImpl
        extends BaseServiceImpl<PhobiaEntity, PhobiaRepository>
        implements PhobiaService {
    @Autowired
    public PhobiaServiceImpl(PhobiaRepository repository) {
        super(repository);
    }
}
