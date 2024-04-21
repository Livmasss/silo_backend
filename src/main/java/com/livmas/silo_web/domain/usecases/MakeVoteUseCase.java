package com.livmas.silo_web.domain.usecases;

import com.livmas.silo_web.domain.exceptions.WrongStepException;
import com.livmas.silo_web.domain.models.enums.GameStep;
import com.livmas.silo_web.domain.session.GameSession;
import com.livmas.silo_web.domain.session.SessionsManager;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class MakeVoteUseCase {
    private SessionsManager sessionsManager;
    public MakeVoteUseCase(
            SessionsManager sessionsManager
    ) {
        this.sessionsManager = sessionsManager;
    }
    public void execute(UUID roomId, int playerId, int targetId) throws WrongStepException {
        GameSession game = sessionsManager.findGame(roomId);

        if (game.getStep() != GameStep.VOTING)
            throw new WrongStepException();

        game.getVotes().put(playerId, targetId);
    }
}
