package com.livmas.silo_web.data;

import com.livmas.silo_web.data.entities.HealthEntity;
import com.livmas.silo_web.data.entities.CatastropheEntity;
import com.livmas.silo_web.data.entities.ProfessionEntity;
import com.livmas.silo_web.data.services.impl.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;



@SpringBootTest
class HibernateTests {
    @Autowired
    HealthServiceImpl actionService;
    @Autowired
    CatastropheServiceImpl catastropheService;
    @Autowired
    CharacterServiceImpl characterService;
    @Autowired
    GenderServiceImpl genderService;
    @Autowired
    HealthServiceImpl healthService;
    @Autowired
    HobbyServiceImpl hobbyService;
    @Autowired
    InformationServiceImpl informationService;
    @Autowired
    InventoryServiceImpl inventoryService;
    @Autowired
    PhobiaServiceImpl phobiaService;
    @Autowired
    ProfessionServiceImpl professionService;

    @Test
    void CatastropheServiceTest() {
        CatastropheEntity entity = new CatastropheEntity("Зомбу апокалиптик", "Мир захватили зомбу...");

        CatastropheEntity firstCatastrophe = catastropheService.getEntity();

        Assertions.assertEquals(entity.getName(), firstCatastrophe.getName());
        Assertions.assertEquals(entity.getDescription(), firstCatastrophe.getDescription());
    }

    @Test
    void ProfessionServiceTest() {
        ProfessionEntity entity = new ProfessionEntity("Строитель", 0.7f);

        ProfessionEntity firstProfession = professionService.getEntity();

        Assertions.assertEquals(entity.getName(), firstProfession.getName());
        Assertions.assertEquals(entity.getFrequency(), firstProfession.getFrequency());
    }

    @Test
    void HealthServiceTest() {
        HealthEntity entity = new HealthEntity("ВИЧ", 0.2f);

        HealthEntity firstHealth = healthService.getEntity();

        Assertions.assertEquals(entity.getName(), firstHealth.getName());
        Assertions.assertEquals(entity.getFrequency(), firstHealth.getFrequency());
    }
}