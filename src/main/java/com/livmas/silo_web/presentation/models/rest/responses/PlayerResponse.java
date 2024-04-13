package com.livmas.silo_web.presentation.models.rest.responses;

import com.livmas.silo_web.domain.models.enums.PlayerPropertyName;
import com.livmas.silo_web.domain.models.PlayerModel;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlayerResponse {
    private int id;
    private String gender;
    private String health;
    private String personality;
    private String profession;
    private String hobby;
    private String phobia;
    private String inventory;
    private String information;
    private String action;

    public PlayerResponse(PlayerModel model) {
        this.id = model.getId();
        this.gender = model.get(PlayerPropertyName.GENDER).getContent();
        this.health = model.get(PlayerPropertyName.HEALTH).getContent();
        this.personality = model.get(PlayerPropertyName.PERSONALITY).getContent();
        this.profession = model.get(PlayerPropertyName.PROFESSION).getContent();
        this.hobby = model.get(PlayerPropertyName.HOBBY).getContent();
        this.phobia = model.get(PlayerPropertyName.PHOBIA).getContent();
        this.inventory = model.get(PlayerPropertyName.INVENTORY).getContent();
        this.information = model.get(PlayerPropertyName.INFORMATION).getContent();
        this.action = model.get(PlayerPropertyName.ACTION).getContent();
    }
}
