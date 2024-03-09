package com.livmas.silo_web.presenter.controllers;

import com.livmas.silo_web.domain.rooms.RoomsManager;
import com.livmas.silo_web.presenter.models.CreateRoomResponse;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class RoomRestController {
    public RoomRestController(RoomsManager manager) {
        this.roomsManager = manager;
    }
    private final RoomsManager roomsManager;

    @PostMapping("/api/rooms")
    public CreateRoomResponse createRoom() {
        return new CreateRoomResponse(roomsManager.createNewRoom());
    }

    @PostMapping("/api/rooms/{room_id}")
    public void startGame(@PathVariable("room_id") int roomId) {
    }

    @PutMapping("/api/rooms/{room_id}")
    public void addToRoom(@PathVariable("room_id") int roomId) {

    }
}
