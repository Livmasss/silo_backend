package com.livmas.silo_web.domain.usecases;

import com.livmas.silo_web.domain.exceptions.PropertyAlreadyOpenedException;
import com.livmas.silo_web.domain.models.enums.PlayerPropertyName;
import com.livmas.silo_web.domain.session.GameSession;
import com.livmas.silo_web.domain.session.SessionsManager;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UsePlayerActionUseCase {
    private final SessionsManager sessionsManager;

    public UsePlayerActionUseCase(
            SessionsManager sessionsManager
    ) {
        this.sessionsManager = sessionsManager;
    }

    public void execute(UUID sessionId, int playerId) throws PropertyAlreadyOpenedException {
        GameSession game = sessionsManager.findGame(sessionId);

        game.openProperty(playerId, PlayerPropertyName.ACTION);
    }
}
