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
    @SendTo("/rooms/{room_id}")
    public RoomVisitorMessage connectToRoom(ConnectMessage connectMessage, @DestinationVariable("room_id") UUID roomId) {
        RoomVisitorMessage message = new RoomVisitorMessage();

        try {
            roomsManager.connectToRoom(roomId, connectMessage.name);
            logger.info("Connection to room: " + roomId);
            message.addAll(roomsManager.readRoomVisitors(roomId).stream().map( visitor ->
                    visitor.name
            ).toList());
        } catch (Exception e) {
            logger.info("Room not found");
        }

        return message;
    }

    @SendTo("/pong")
    @MessageMapping("/ping")
    public String ping() {
        logger.info("ping occurred");
        return "pong";
    }
}
