package com.livmas.silo_web.data.services.impl;

import com.livmas.silo_web.data.entities.GenderEntity;
import com.livmas.silo_web.data.repositories.GenderRepository;
import com.livmas.silo_web.data.services.GenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GenderServiceImpl
        extends BaseServiceImpl<GenderEntity, GenderRepository>
        implements GenderService {
    @Autowired
    public GenderServiceImpl(GenderRepository repository) {
        super(repository);
    }
}
