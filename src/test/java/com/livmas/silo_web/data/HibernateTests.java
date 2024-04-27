package com.livmas.silo_web.data;

import com.livmas.silo_web.data.entities.CatastropheEntity;
import com.livmas.silo_web.data.services.impl.CatastropheServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;



@SpringBootTest
class HibernateTests {
    @Autowired
    CatastropheServiceImpl catastropheService;

    @Test
    void CatastropheRepositoryTest() {
        CatastropheEntity entity = new CatastropheEntity("Зомбу апокалиптик", "Мир захватили зомбу...");

        CatastropheEntity firstCatastrophe = catastropheService.getEntity();

        Assertions.assertEquals(entity.getName(), firstCatastrophe.getName());
        Assertions.assertEquals(entity.getDescription(), firstCatastrophe.getDescription());
    }
}