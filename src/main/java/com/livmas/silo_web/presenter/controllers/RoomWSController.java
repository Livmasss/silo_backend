package com.livmas.silo_web.presenter.controllers;

import com.livmas.silo_web.domain.rooms.RoomsManager;
import com.livmas.silo_web.presenter.models.ConnectMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.UUID;

@Controller
public class RoomWSController {
    @Autowired
    public RoomWSController(
            RoomsManager manager
    ) {
        this.roomsManager = manager;
    }
    private final RoomsManager roomsManager;

//    private final String basePath = "api/ws";


    @MessageMapping("/connect_to_room/{room_id}")
    public void connectToRoom(ConnectMessage message, @DestinationVariable("room_id") UUID roomId) {
        System.out.println("Connection to room");
        roomsManager.connectToRoom(roomId, message.name);
    }
}
