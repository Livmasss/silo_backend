package com.livmas.silo_web.presenter.controllers;

import com.livmas.silo_web.domain.rooms.RoomsManager;
import com.livmas.silo_web.presenter.models.ConnectMessage;
import com.livmas.silo_web.presenter.models.RoomVisitorMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.util.UUID;

@Controller
public class RoomWSController {
    @Autowired
    public RoomWSController(
            RoomsManager manager
    ) {
        this.roomsManager = manager;
    }
    Logger logger = LoggerFactory.getLogger(SpringApplication.class);
    private final RoomsManager roomsManager;

//    private final String basePath = "api/ws";


    @MessageMapping("/connect_to_room/{room_id}")
//    @SendTo("/room/{room_id}")
    public void connectToRoom(ConnectMessage message, @DestinationVariable("room_id") UUID roomId) {
        try {
            roomsManager.connectToRoom(roomId, message.name);
            logger.info("Connection to room: " + roomId);
        } catch (Exception e) {
            logger.info("Room not found");
        }
    }

    @SendTo("/pong")
    @MessageMapping("/ping")
    public String ping() {
        logger.info("ping occurred");
        return "pong";
    }
}
