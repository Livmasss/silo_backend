package com.livmas.silo_web.domain.usecases.players;

import com.livmas.silo_web.domain.session.GameSessionManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class GetPlayerIdUseCase {

    private final GameSessionManager gameSessionManager;

    @Autowired
    GetPlayerIdUseCase(
            GameSessionManager gameSessionManager
    ) {
        this.gameSessionManager = gameSessionManager;
    }

    public int execute(UUID roomId, String name) {
        return gameSessionManager.getPlayerIdByName(roomId, name);
    }
}
