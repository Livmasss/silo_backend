package com.livmas.silo_web.models;

public class PlayerResponse {
    public String gender;
    public String health;
    public String personality;
    public String profession;
    public String hobby;
    public String phobia;
    public String inventory;
    public String information;
    public String action;

    public PlayerResponse(String gender,
        String health,
        String personality,
        String profession,
        String hobby,
        String phobia,
        String inventory,
        String information,
        String action
    ) {
        this.gender = gender;
        this.health = health;
        this.personality = personality;
        this.profession = profession;
        this.hobby = hobby;
        this.phobia = phobia;
        this.inventory = inventory;
        this.information = information;
        this.action = action;
    }
}
