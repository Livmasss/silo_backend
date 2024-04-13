package com.livmas.silo_web.domain.models;

import com.livmas.silo_web.domain.models.enums.PlayerPropertyName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PlayerModelTest {
    PlayerModel model = new PlayerModel(0,
            "name",
            List.of(
                    "gender",
                    "health",
                    "personality",
                    "profession",
                    "hobby",
                    "phobia",
                    "inventory",
                    "information",
                    "action"));

    @Test
    void testPlayerModel() {
        assertEquals("name", model.getName());
        assertEquals("hobby", model.get(PlayerPropertyName.HOBBY).content);
        assertEquals("information", model.get(PlayerPropertyName.INFORMATION).content);
        assertEquals("health", model.get(PlayerPropertyName.HEALTH).content);
        assertEquals("phobia", model.get(PlayerPropertyName.PHOBIA).content);
        assertEquals("profession", model.get(PlayerPropertyName.PROFESSION).content);
        assertEquals("inventory", model.get(PlayerPropertyName.INVENTORY).content);
        assertEquals("action", model.get(PlayerPropertyName.ACTION).content);
        assertEquals("gender", model.get(PlayerPropertyName.GENDER).content);
        assertEquals("personality", model.get(PlayerPropertyName.PERSONALITY).content);
    }
}
