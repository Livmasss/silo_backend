package com.livmas.silo_web.data.services.impl;

import com.livmas.silo_web.data.entities.*;
import com.livmas.silo_web.data.services.*;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class AllPropertiesServiceImpl implements AllPropertiesService {
    ActionService actionService;
    CatastropheService catastropheService;
    CharacterService characterService;
    GenderService genderService;
    HealthService healthService;
    HobbyService hobbyService;
    InformationService informationService;
    InventoryService inventoryService;
    PhobiaService phobiaService;
    ProfessionService professionService;

    @Override
    public ActionEntity getAction() {
        return actionService.getEntity();
    }

    @Override
    public CatastropheEntity getCatastrophe() {
        return catastropheService.getEntity();
    }

    @Override
    public CharacterEntity getCharacter() {
        return characterService.getEntity();
    }

    @Override
    public GenderEntity getGender() {
        return genderService.getEntity();
    }

    @Override
    public HealthEntity getHealth() {
        return healthService.getEntity();
    }

    @Override
    public HobbyEntity getHobby() {
        return hobbyService.getEntity();
    }

    @Override
    public InformationEntity getInformation() {
        return informationService.getEntity();
    }

    @Override
    public InventoryEntity getInventory() {
        return inventoryService.getEntity();
    }

    @Override
    public PhobiaEntity getPhobia() {
        return phobiaService.getEntity();
    }

    @Override
    public ProfessionEntity getProfession() {
        return professionService.getEntity();
    }
}
