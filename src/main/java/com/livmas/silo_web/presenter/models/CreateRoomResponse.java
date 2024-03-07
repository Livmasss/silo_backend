package com.livmas.silo_web.presenter.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateRoomResponse {
    @JsonProperty("room_id")
    int roomId;

    public CreateRoomResponse(int roomId) {
        this.roomId = roomId;
    }
}
