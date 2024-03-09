package com.livmas.silo_web.presenter.controllers;

import com.livmas.silo_web.domain.rooms.RoomsManager;
import com.livmas.silo_web.presenter.models.ConnectMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

import java.util.UUID;

@Controller
public class RoomController {
    @Autowired
    public RoomController(
            RoomsManager manager
    ) {
        this.roomsManager = manager;
    }
    private final RoomsManager roomsManager;

//    private final String basePath = "api/ws";


    @MessageMapping("/ws/connect_to_room/{room_id}")
    public void connectToRoom(ConnectMessage message, @DestinationVariable("room_id") UUID roomId) {
        System.out.println("Connection to room");
        roomsManager.connectToRoom(roomId, message.name);
    }
}
