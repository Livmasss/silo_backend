package com.livmas.silo_web.domain.models;

import com.livmas.silo_web.domain.PlayerPropertyName;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;

@EqualsAndHashCode(callSuper = false)
@Getter
@Setter
public class PlayerModel extends HashMap<PlayerPropertyName, PlayerProperty> {
    private int id;

    public PlayerModel(
            int id,
            List<String> props
    ) {
        this.id = id;

        var propsNames = PlayerPropertyName.values();
        for (int i = 0; i < propsNames.length; i++) {
            put(propsNames[i], new PlayerProperty(props.get(i), false));
        }
    }

    public void putProp(PlayerPropertyName propName, String propContent) {
        put(propName, new PlayerProperty(propContent, false));
    }
}
