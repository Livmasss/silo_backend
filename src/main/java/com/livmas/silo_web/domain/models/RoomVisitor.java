package com.livmas.silo_web.domain.models;

import java.util.UUID;

public class RoomVisitor {
    public RoomVisitor(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    public UUID id;
    public String name;
}
