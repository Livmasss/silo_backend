package com.livmas.silo_web.presentation.models.rest.responses;

import com.livmas.silo_web.domain.PlayerPropertyName;
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
        this.gender = model.get(PlayerPropertyName.gender).getContent();
        this.health = model.get(PlayerPropertyName.health).getContent();
        this.personality = model.get(PlayerPropertyName.personality).getContent();
        this.profession = model.get(PlayerPropertyName.profession).getContent();
        this.hobby = model.get(PlayerPropertyName.hobby).getContent();
        this.phobia = model.get(PlayerPropertyName.phobia).getContent();
        this.inventory = model.get(PlayerPropertyName.inventory).getContent();
        this.information = model.get(PlayerPropertyName.information).getContent();
        this.action = model.get(PlayerPropertyName.action).getContent();
    }
}
