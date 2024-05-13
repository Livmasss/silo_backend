package com.livmas.silo_web.data;

import com.livmas.silo_web.data.entities.BaseEntity;
import com.livmas.silo_web.data.services.BaseService;
import com.livmas.silo_web.data.services.impl.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;



@SpringBootTest
class HibernateTests {
    @Autowired
    ActionServiceImpl actionService;
    @Autowired
    BunkerServiceImpl bunkerService;
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
    void ActionServiceTest() {
        BaseServiceTest(actionService);
    }

    @Test
    void BunkerServiceTest() {
        BaseServiceTest(bunkerService);
    }

    @Test
    void CatastropheServiceTest() {
        BaseServiceTest(catastropheService);
    }

    @Test
    void CharacterServiceTest() {
        BaseServiceTest(characterService);
    }

    @Test
    void GenderServiceTest() {
        BaseServiceTest(genderService);
    }

    @Test
    void HealthServiceTest() {
        BaseServiceTest(healthService);
    }

    @Test
    void HobbyServiceTest() {
        BaseServiceTest(hobbyService);
    }

    @Test
    void InformationServiceTest() {
        BaseServiceTest(informationService);
    }

    @Test
    void InventoryServiceTest() {
        BaseServiceTest(inventoryService);
    }

    @Test
    void PhobiaServiceTest() {
        BaseServiceTest(phobiaService);
    }

    @Test
    void ProfessionServiceTest() {
        BaseServiceTest(professionService);
    }


    <T extends BaseEntity> void BaseServiceTest(BaseService<T> service) {
        for (int i = 0; i < 10; i++) {
            T randomProperty = service.getEntity();
            var foundedProperty = service.getById(randomProperty.getId());

            Assertions.assertFalse(foundedProperty.isEmpty());

            Assertions.assertEquals(foundedProperty.get().getName(), randomProperty.getName());
            Assertions.assertEquals(foundedProperty.get().getFrequency(), randomProperty.getFrequency());
        }
    }
}