package com.livmas.silo_web.domain.usecases.players;

import com.livmas.silo_web.domain.models.PlayerModel;
import com.livmas.silo_web.domain.session.GameSessionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class GetPlayerDataUseCase {

    private final GameSessionManager gameSessionManager;

    @Autowired
    GetPlayerDataUseCase(
            GameSessionManager gameSessionManager
    ) {
        this.gameSessionManager = gameSessionManager;
    }

    public PlayerModel execute(UUID roomId, int playerId) {
        return gameSessionManager.getSessionPlayerData(roomId, playerId);
    }
}
