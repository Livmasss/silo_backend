package com.livmas.silo_web.domain.usecases.players;

import com.livmas.silo_web.domain.session.SessionsManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class GetPlayerIdUseCase {

    private final SessionsManager sessionsManager;

    @Autowired
    GetPlayerIdUseCase(
            SessionsManager sessionsManager
    ) {
        this.sessionsManager = sessionsManager;
    }

    public int execute(UUID roomId, String name) {
        return sessionsManager.getPlayerIdByName(roomId, name);
    }
}
