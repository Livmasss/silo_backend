package com.livmas.silo_web.domain.usecases.players;

import com.livmas.silo_web.domain.exceptions.PropertyAlreadyOpenedException;
import com.livmas.silo_web.domain.models.enums.PlayerPropertyName;
import com.livmas.silo_web.domain.session.GameSession;
import com.livmas.silo_web.domain.session.GameSessionManager;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UsePlayerActionUseCase {
    private final GameSessionManager gameSessionManager;

    public UsePlayerActionUseCase(
            GameSessionManager gameSessionManager
    ) {
        this.gameSessionManager = gameSessionManager;
    }

    public void execute(UUID sessionId, int playerId) throws PropertyAlreadyOpenedException {
        try {

            GameSession game = gameSessionManager.findGame(sessionId);

            game.openProperty(playerId, PlayerPropertyName.ACTION);
        }
        catch (Exception e) {

        }
    }
}
