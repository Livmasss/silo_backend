package com.livmas.silo_web.domain.usecases.players;

import com.livmas.silo_web.domain.exceptions.OpenPropertyInForeignTurnException;
import com.livmas.silo_web.domain.exceptions.PropertyAlreadyOpenedException;
import com.livmas.silo_web.domain.exceptions.WrongStepException;
import com.livmas.silo_web.domain.exceptions.WrongUseCaseException;
import com.livmas.silo_web.domain.models.enums.GameStep;
import com.livmas.silo_web.domain.models.enums.PlayerPropertyName;
import com.livmas.silo_web.domain.session.GameSession;
import com.livmas.silo_web.domain.session.GameSessionManager;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class OpenPlayerPropertyUseCase {
    private final GameSessionManager gameSessionManager;

    public OpenPlayerPropertyUseCase(
            GameSessionManager gameSessionManager
    ) {
        this.gameSessionManager = gameSessionManager;
    }

    public void execute(UUID sessionId, int playerId, PlayerPropertyName propertyName) throws PropertyAlreadyOpenedException, OpenPropertyInForeignTurnException, WrongUseCaseException, WrongStepException {
        try {
            if (propertyName == PlayerPropertyName.ACTION)
                throw new WrongUseCaseException();

            GameSession game = gameSessionManager.findGame(sessionId);

            if (game.getStep() != GameStep.PROPERTIES_OPENING)
                throw new WrongStepException();

            if (game.getCurrentPlayerId() != playerId)
                throw new OpenPropertyInForeignTurnException();

            game.openProperty(playerId, propertyName);
            game.nextTurn();
        }
        catch (Exception e) {
        }
    }
}
