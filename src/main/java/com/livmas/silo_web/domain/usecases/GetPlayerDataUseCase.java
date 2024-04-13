package com.livmas.silo_web.domain.usecases;

import com.livmas.silo_web.domain.models.PlayerModel;
import com.livmas.silo_web.domain.session.SessionsManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class GetPlayerDataUseCase {

    private final SessionsManager sessionsManager;

    @Autowired
    GetPlayerDataUseCase(
            SessionsManager sessionsManager
    ) {
        this.sessionsManager = sessionsManager;
    }

    public PlayerModel execute(UUID roomId, int playerId) {
        return sessionsManager.getSessionPlayerData(roomId, playerId);
    }
}
