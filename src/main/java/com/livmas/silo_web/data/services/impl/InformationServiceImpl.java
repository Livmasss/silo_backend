package com.livmas.silo_web.data.services.impl;

import com.livmas.silo_web.data.entities.InformationEntity;
import com.livmas.silo_web.data.repositories.InformationRepository;
import com.livmas.silo_web.data.services.InformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InformationServiceImpl
        extends BaseServiceImpl<InformationEntity, InformationRepository>
        implements InformationService {
    @Autowired
    public InformationServiceImpl(InformationRepository repository) {
        super(repository);
    }
}
