package com.livmas.silo_web.communication.controllers;

import com.livmas.silo_web.domain.rooms.RoomsManager;
import com.livmas.silo_web.communication.models.rest.requests.CreateRoomRequest;
import com.livmas.silo_web.communication.models.rest.responses.CreateRoomResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class RoomsRestController {

    Logger logger = LoggerFactory.getLogger(RoomsRestController.class);
    public RoomsRestController(RoomsManager manager) {
        this.roomsManager = manager;
    }
    private final RoomsManager roomsManager;

    @PostMapping("/api/rooms")
    public CreateRoomResponse createRoom(@RequestBody CreateRoomRequest request) {
        UUID id = roomsManager.createNewRoom(request.name());
        logger.info("Room created with id: " + id + "Creator name: " + request.name());
        return new CreateRoomResponse(id);
    }
}
