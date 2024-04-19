package com.livmas.silo_web.presentation.controllers;

import com.livmas.silo_web.domain.exceptions.WrongUseCaseException;
import com.livmas.silo_web.domain.models.OpenedPlayerModel;
import com.livmas.silo_web.domain.usecases.GetOpenedPlayersDataUseCase;
import com.livmas.silo_web.domain.usecases.OpenPlayerPropertyUseCase;
import com.livmas.silo_web.domain.usecases.UsePlayerActionUseCase;
import com.livmas.silo_web.presentation.models.sock.OpenPropertyMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Controller
public class PlayerWSController {
    private final GetOpenedPlayersDataUseCase getOpenedPlayersDataUseCase;
    private final OpenPlayerPropertyUseCase openPlayerPropertyUseCase;
    private final UsePlayerActionUseCase usePlayerActionUseCase;
    private final Logger logger = LoggerFactory.getLogger(PlayerWSController.class);


    @Autowired
    public PlayerWSController(
            GetOpenedPlayersDataUseCase getOpenedPlayersDataUseCase,
            OpenPlayerPropertyUseCase openPlayerPropertyUseCase,
            UsePlayerActionUseCase usePlayerActionUseCase
    ) {
        this.getOpenedPlayersDataUseCase = getOpenedPlayersDataUseCase;
        this.openPlayerPropertyUseCase = openPlayerPropertyUseCase;
        this.usePlayerActionUseCase = usePlayerActionUseCase;
    }

    @MessageMapping("/game/open_property/{room_id}")
    @SendTo("/game/property/{room_id}")
    public List<OpenedPlayerModel> openProperty(@DestinationVariable("room_id") UUID roomId, OpenPropertyMessage message) {
        try {
            openPlayerPropertyUseCase.execute(roomId, message.getPlayerId(), message.getProperty());
        }
        catch (WrongUseCaseException wrongUseCaseException) {
            try {
                usePlayerActionUseCase.execute(roomId, message.getPlayerId());
            }
            catch (Exception e) {
                return Collections.emptyList();
            }
        }
        catch (Exception e) {
            return Collections.emptyList();
        }

        return getOpenedPlayersDataUseCase.execute(roomId);
    }
}
