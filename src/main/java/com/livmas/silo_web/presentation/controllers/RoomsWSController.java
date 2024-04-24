package com.livmas.silo_web.presentation.controllers;

import com.livmas.silo_web.domain.session.SessionsManager;
import com.livmas.silo_web.presentation.models.sock.ConnectMessage;
import com.livmas.silo_web.presentation.models.sock.RoomVisitorMessage;
import com.livmas.silo_web.domain.models.PlayerModel;
import com.livmas.silo_web.domain.models.RoomVisitor;
import com.livmas.silo_web.domain.rooms.RoomsManager;
import com.livmas.silo_web.domain.session.GameSession;
import com.livmas.silo_web.domain.usecases.players.GetRandomPlayerModelUseCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

@Controller
public class RoomsWSController {
    private final SessionsManager sessionManager;
    private final Logger logger = LoggerFactory.getLogger(RoomsWSController.class);
    private final RoomsManager roomsManager;
    private final GetRandomPlayerModelUseCase getRandomPlayerModelUseCase;

    @Autowired
    public RoomsWSController(
            RoomsManager roomManager,
            SessionsManager sessionManager,
            GetRandomPlayerModelUseCase getRandomPlayerModelUseCase
    ) {
        this.sessionManager = sessionManager;
        this.roomsManager = roomManager;
        this.getRandomPlayerModelUseCase = getRandomPlayerModelUseCase;
    }

    @MessageMapping("/connect_to_room/{room_id}")
    @SendTo("/rooms/{room_id}")
    public RoomVisitorMessage connectToRoom(ConnectMessage connectMessage, @DestinationVariable("room_id") UUID roomId) {
        RoomVisitorMessage message = new RoomVisitorMessage();

        try {
            roomsManager.connectToRoom(roomId, connectMessage.name);
            List<RoomVisitor> visitors = roomsManager.readRoomVisitors(roomId);
            logger.info("Connection to room: %s".formatted(roomId));

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
        AtomicInteger currPlayerId = new AtomicInteger();
        sessionManager.createNewSession(
                new GameSession(roomId,
                        roomsManager.readRoomVisitors(roomId).stream().map(visitor -> {
                            PlayerModel player = getRandomPlayerModelUseCase.execute();
                            player.setName(visitor.name);
                            player.setId(currPlayerId.get());
                            currPlayerId.getAndIncrement();
                            return player;
                        }).toList()
                )
        );

        logger.info("Game started in room: %s".formatted(roomId.toString()));
        return "";
    }



    @MessageMapping("/ping")
    @SendTo("/pong")
    public String ping() {
        logger.info("ping occurred");
        return "pong";
    }
}
