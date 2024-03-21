package com.livmas.silo_web.presenter.controllers;

import com.livmas.silo_web.domain.models.PlayerModel;
import com.livmas.silo_web.domain.models.RoomVisitor;
import com.livmas.silo_web.domain.rooms.Room;
import com.livmas.silo_web.domain.rooms.RoomsManager;
import com.livmas.silo_web.domain.session.GameSession;
import com.livmas.silo_web.domain.session.usecases.GetRandomPlayerModelUseCase;
import com.livmas.silo_web.presenter.models.sock.ConnectMessage;
import com.livmas.silo_web.presenter.models.sock.RoomVisitorMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.UUID;

@Controller
public class RoomWSController {
    @Autowired
    public RoomWSController(
            RoomsManager manager,
            GetRandomPlayerModelUseCase getRandomPlayerModelUseCase
    ) {
        this.roomsManager = manager;
        this.getRandomPlayerModelUseCase = getRandomPlayerModelUseCase;
    }
    Logger logger = LoggerFactory.getLogger(SpringApplication.class);
    private final RoomsManager roomsManager;
    private final GetRandomPlayerModelUseCase getRandomPlayerModelUseCase;

    @MessageMapping("/connect_to_room/{room_id}")
    @SendTo("/rooms/{room_id}")
    public RoomVisitorMessage connectToRoom(ConnectMessage connectMessage, @DestinationVariable("room_id") UUID roomId) {
        RoomVisitorMessage message = new RoomVisitorMessage();

        try {
            roomsManager.connectToRoom(roomId, connectMessage.name);
            List<RoomVisitor> visitors = roomsManager.readRoomVisitors(roomId);
            logger.info("Connection to room: " + roomId);

            message.addAll(visitors.stream().map( visitor ->
                    visitor.name
            ).toList());
        }
        catch (Exception e) {
            logger.info("Room not found");
        }

        return message;
    }

    @MessageMapping("/start_game/{room_id}")
    @SendTo("/game_started/{room_id}")
    public String startGame(@DestinationVariable("room_id") UUID roomId) {
        new GameSession(roomsManager.readRoomVisitors(roomId).stream().map(visitor -> {
            PlayerModel player = getRandomPlayerModelUseCase.execute();
            player.name = visitor.name;
            return player;
        }).toList());

        logger.info("Game started in room: " + roomId.toString());
        return "";
    }



    @MessageMapping("/ping")
    @SendTo("/pong")
    public String ping() {
        logger.info("ping occurred");
        return "pong";
    }
}
