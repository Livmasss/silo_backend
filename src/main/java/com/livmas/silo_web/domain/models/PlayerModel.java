package com.livmas.silo_web.domain.models;

import com.livmas.silo_web.domain.models.enums.PlayerPropertyName;
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
    private String name;
    private Boolean isAlive = true;

    public PlayerModel(
            int id,
            String name,
            List<String> props
    ) {
        this.id = id;
        this.name = name;

        var propsNames = PlayerPropertyName.values();
        for (int i = 0; i < propsNames.length; i++) {
            put(propsNames[i], new PlayerProperty(props.get(i), false));
        }
    }

    public void putProp(PlayerPropertyName propName, String propContent) {
        put(propName, new PlayerProperty(propContent, false));
    }

    public String getOpenedContent(PlayerPropertyName propName) {
        PlayerProperty property = get(propName);

        if (property.isOpened)
            return property.getContent();
        else
            return "";
    }

    public String getContent(PlayerPropertyName propName) {
        PlayerProperty property = get(propName);
        return property.getContent();
    }
}
