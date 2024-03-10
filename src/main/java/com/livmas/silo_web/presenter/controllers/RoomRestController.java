package com.livmas.silo_web.presenter.controllers;

import com.livmas.silo_web.domain.rooms.RoomsManager;
import com.livmas.silo_web.presenter.models.CreateRoomResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class RoomRestController {

    Logger logger = LoggerFactory.getLogger(SpringApplication.class);
    public RoomRestController(RoomsManager manager) {
        this.roomsManager = manager;
    }
    private final RoomsManager roomsManager;

    @PostMapping("/api/rooms")
    public CreateRoomResponse createRoom() {
        UUID id = roomsManager.createNewRoom();
        logger.info("Room created with id: " + id);
        return new CreateRoomResponse(id);
    }

    @PostMapping("/api/rooms/{room_id}")
    public void startGame(@PathVariable("room_id") int roomId) {
    }

    @PutMapping("/api/rooms/{room_id}")
    public void addToRoom(@PathVariable("room_id") int roomId) {

    }
}
