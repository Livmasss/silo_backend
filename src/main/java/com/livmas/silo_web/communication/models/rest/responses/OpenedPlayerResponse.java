package com.livmas.silo_web.communication.models.rest.responses;

import com.livmas.silo_web.domain.models.OpenedPlayerModel;

public class OpenedPlayerResponse {
    public String name;
    public String gender;
    public String health;
    public String personality;
    public String profession;
    public String hobby;
    public String phobia;
    public String inventory;
    public String information;
    public String action;

    public OpenedPlayerResponse(OpenedPlayerModel model) {
        this.name = model.name;
        this.gender = model.gender;
        this.health = model.health;
        this.personality = model.personality;
        this.profession = model.profession;
        this.hobby = model.hobby;
        this.phobia = model.phobia;
        this.inventory = model.inventory;
        this.information = model.information;
        this.action = model.action;
    }
}
