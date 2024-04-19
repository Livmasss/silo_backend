package com.livmas.silo_web.domain.usecases;

import com.livmas.silo_web.domain.exceptions.OpenPropertyInForeignTurnException;
import com.livmas.silo_web.domain.exceptions.PropertyAlreadyOpenedException;
import com.livmas.silo_web.domain.exceptions.WrongUseCaseException;
import com.livmas.silo_web.domain.models.enums.PlayerPropertyName;
import com.livmas.silo_web.domain.session.GameSession;
import com.livmas.silo_web.domain.session.SessionsManager;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class OpenPlayerPropertyUseCase {
    private final SessionsManager sessionsManager;

    public OpenPlayerPropertyUseCase(
            SessionsManager sessionsManager
    ) {
        this.sessionsManager = sessionsManager;
    }

    public void execute(UUID sessionId, int playerId, PlayerPropertyName propertyName) throws PropertyAlreadyOpenedException, OpenPropertyInForeignTurnException, WrongUseCaseException {
        if (propertyName == PlayerPropertyName.ACTION)
            throw new WrongUseCaseException();

        GameSession game = sessionsManager.findGame(sessionId);

        if (game.getCurrentPlayerId() != playerId)
            throw new OpenPropertyInForeignTurnException();

        game.openProperty(playerId, propertyName);
        game.nextTurn();
    }
}
