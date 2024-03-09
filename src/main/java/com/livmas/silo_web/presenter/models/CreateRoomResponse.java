package com.livmas.silo_web.presenter.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

public class CreateRoomResponse {
    @JsonProperty("room_id")
    UUID roomId;

    public CreateRoomResponse(UUID roomId) {
        this.roomId = roomId;
    }
}
