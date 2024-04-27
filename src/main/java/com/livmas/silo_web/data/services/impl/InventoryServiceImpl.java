package com.livmas.silo_web.data.services.impl;

import com.livmas.silo_web.data.entities.InventoryEntity;
import com.livmas.silo_web.data.repositories.InventoryRepository;
import com.livmas.silo_web.data.services.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InventoryServiceImpl
        extends BaseServiceImpl<InventoryEntity, InventoryRepository>
        implements InventoryService {
    @Autowired
    public InventoryServiceImpl(InventoryRepository repository) {
        super(repository);
    }
}
