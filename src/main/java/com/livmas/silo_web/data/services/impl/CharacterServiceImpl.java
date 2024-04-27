package com.livmas.silo_web.data.services.impl;

import com.livmas.silo_web.data.entities.CharacterEntity;
import com.livmas.silo_web.data.repositories.CharacterRepository;
import com.livmas.silo_web.data.services.CharacterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CharacterServiceImpl
        extends BaseServiceImpl<CharacterEntity, CharacterRepository>
        implements CharacterService {
    @Autowired
    public CharacterServiceImpl(CharacterRepository repository) {
        super(repository);
    }
}
