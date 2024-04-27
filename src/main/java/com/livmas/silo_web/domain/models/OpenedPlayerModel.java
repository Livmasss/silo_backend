package com.livmas.silo_web.domain.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class OpenedPlayerModel {
    private int id;
    private String name;
    private String gender;
    private String health;
    private String personality;
    private String profession;
    private String hobby;
    private String phobia;
    private String inventory;
    private String information;
    private String action;
}
