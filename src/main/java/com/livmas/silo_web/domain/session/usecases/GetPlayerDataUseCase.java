package com.livmas.silo_web.domain.session.usecases;

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

    int i = 0;

    public PlayerModel execute(UUID roomId, int player_id) {
        return sessionsManager.getPlayerDataSession(roomId, player_id);
    }
}
