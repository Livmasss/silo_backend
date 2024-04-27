package com.livmas.silo_web.data.services.impl;

import com.livmas.silo_web.data.entities.HobbyEntity;
import com.livmas.silo_web.data.repositories.HobbyRepository;
import com.livmas.silo_web.data.services.HobbyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HobbyServiceImpl
        extends BaseServiceImpl<HobbyEntity, HobbyRepository>
        implements HobbyService {
    @Autowired
    public HobbyServiceImpl(HobbyRepository repository) {
        super(repository);
    }
}
