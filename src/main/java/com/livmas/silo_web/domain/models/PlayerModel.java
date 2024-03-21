package com.livmas.silo_web.domain.models;

public class PlayerModel {
    public int id;
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

    public PlayerModel(
            int id,
            String name,
            String gender,
            String health,
            String personality,
            String profession,
            String hobby,
            String phobia,
            String inventory,
            String information,
            String action
    ) {
        this.id = id;
        this.name = name;
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
