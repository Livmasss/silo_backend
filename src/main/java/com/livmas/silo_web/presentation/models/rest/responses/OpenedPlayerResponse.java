package com.livmas.silo_web.presentation.models.rest.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class OpenedPlayerResponse {
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
