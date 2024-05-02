package com.livmas.silo_web.presentation.controllers.ws;

import com.livmas.silo_web.domain.exceptions.NotEnoughPlayersException;
import com.livmas.silo_web.domain.session.GameSessionFactory;
import com.livmas.silo_web.domain.session.GameSessionManager;
import com.livmas.silo_web.domain.usecases.rooms.CreateGameSessionUseCase;
import com.livmas.silo_web.presentation.models.ws.ConnectMessage;
import com.livmas.silo_web.presentation.models.ws.RoomVisitorMessage;
import com.livmas.silo_web.domain.models.RoomVisitor;
import com.livmas.silo_web.domain.rooms.RoomsManager;
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

@Controller
public class RoomsWSController {
    private final GameSessionManager sessionManager;
    private final GameSessionFactory gameSessionFactory;
    private final Logger logger = LoggerFactory.getLogger(RoomsWSController.class);
    private final RoomsManager roomsManager;
    private final CreateGameSessionUseCase createGameSessionUseCase;
    private final GetRandomPlayerModelUseCase getRandomPlayerModelUseCase;

    @Autowired
    public RoomsWSController(
            RoomsManager roomManager,
            GameSessionManager sessionManager,
            GameSessionFactory gameSessionFactory,
            GetRandomPlayerModelUseCase getRandomPlayerModelUseCase,
            CreateGameSessionUseCase createGameSessionUseCase
    ) {
        this.sessionManager = sessionManager;
        this.roomsManager = roomManager;
        this.gameSessionFactory = gameSessionFactory;
        this.getRandomPlayerModelUseCase = getRandomPlayerModelUseCase;
        this.createGameSessionUseCase = createGameSessionUseCase;
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
    public Boolean startGame(@DestinationVariable("room_id") UUID roomId) {
        try {
            createGameSessionUseCase.execute(roomId);
        } catch (NotEnoughPlayersException e) {
            logger.info("Game not started: not enough players");
            return Boolean.FALSE;
        }

        logger.info("Game started in room: %s".formatted(roomId.toString()));
        return Boolean.TRUE;
    }



    @MessageMapping("/ping")
    @SendTo("/pong")
    public String ping() {
        logger.info("ping occurred");
        return "pong";
    }
}
