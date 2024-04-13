package com.livmas.silo_web.domain.models;

import com.livmas.silo_web.domain.PlayerPropertyName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerModelTest {
    PlayerModel model = new PlayerModel(0,
            List.of("name",
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
        assertEquals(model.get(PlayerPropertyName.name).content, "name");
        assertEquals(model.get(PlayerPropertyName.hobby).content, "hobby");
        assertEquals(model.get(PlayerPropertyName.information).content, "information");
        assertEquals(model.get(PlayerPropertyName.health).content, "health");
        assertEquals(model.get(PlayerPropertyName.phobia).content, "phobia");
        assertEquals(model.get(PlayerPropertyName.profession).content, "profession");
        assertEquals(model.get(PlayerPropertyName.inventory).content, "inventory");
        assertEquals(model.get(PlayerPropertyName.action).content, "action");
        assertEquals(model.get(PlayerPropertyName.gender).content, "gender");
        assertEquals(model.get(PlayerPropertyName.personality).content, "personality");
    }
}
