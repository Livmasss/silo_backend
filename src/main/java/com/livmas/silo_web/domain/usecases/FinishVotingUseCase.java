package com.livmas.silo_web.domain.usecases;

import com.livmas.silo_web.domain.exceptions.NotAllVotesException;
import com.livmas.silo_web.domain.exceptions.WrongStepException;
import com.livmas.silo_web.domain.models.PlayerModel;
import com.livmas.silo_web.domain.models.enums.GameStep;
import com.livmas.silo_web.domain.session.GameSession;
import com.livmas.silo_web.domain.session.SessionsManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class FinishVotingUseCase {
    private SessionsManager sessionsManager;
    private GetAllVotesUseCase getAllVotesUseCase;
    @Autowired
    public FinishVotingUseCase(
            SessionsManager sessionsManager,
            GetAllVotesUseCase getAllVotesUseCase
    ) {
        this.sessionsManager = sessionsManager;
        this.getAllVotesUseCase = getAllVotesUseCase;
    }
    public void execute(UUID roomId) throws NotAllVotesException, WrongStepException {
        GameSession session = sessionsManager.findGame(roomId);

        if (session.getStep() != GameStep.VOTING)
            throw new WrongStepException();

        var votes = getAllVotesUseCase.execute(roomId);

        for (PlayerModel p : session.getPlayers()) {
            if (!votes.containsKey(p.getId())) {
                throw new NotAllVotesException();
            }
        }

        session.endVoting();
    }
}
