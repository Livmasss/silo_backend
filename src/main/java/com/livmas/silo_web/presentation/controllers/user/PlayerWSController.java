package com.livmas.silo_web.presentation.controllers.user;

import com.livmas.silo_web.domain.exceptions.WrongUseCaseException;
import com.livmas.silo_web.domain.models.OpenedPlayerModel;
import com.livmas.silo_web.domain.usecases.players.GetOpenedPlayersDataUseCase;
import com.livmas.silo_web.domain.usecases.players.OpenPlayerPropertyUseCase;
import com.livmas.silo_web.domain.usecases.players.UsePlayerActionUseCase;
import com.livmas.silo_web.presentation.models.ws.OpenPropertyMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.UUID;

@Controller
public class PlayerWSController {
    private final GetOpenedPlayersDataUseCase getOpenedPlayersDataUseCase;
    private final OpenPlayerPropertyUseCase openPlayerPropertyUseCase;
    private final UsePlayerActionUseCase usePlayerActionUseCase;


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
                return getOpenedPlayersDataUseCase.execute(roomId);
            }
        }
        catch (Exception e) {
            return getOpenedPlayersDataUseCase.execute(roomId);
        }

        return getOpenedPlayersDataUseCase.execute(roomId);
    }
}
