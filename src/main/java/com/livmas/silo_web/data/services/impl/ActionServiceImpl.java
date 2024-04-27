package com.livmas.silo_web.data.services.impl;

import com.livmas.silo_web.data.entities.ActionEntity;
import com.livmas.silo_web.data.repositories.ActionRepository;
import com.livmas.silo_web.data.services.ActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActionServiceImpl
        extends BaseServiceImpl<ActionEntity, ActionRepository>
        implements ActionService {
    @Autowired
    public ActionServiceImpl(ActionRepository repository) {
        super(repository);
    }
}
