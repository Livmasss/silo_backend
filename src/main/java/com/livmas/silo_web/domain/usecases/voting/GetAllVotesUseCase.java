package com.livmas.silo_web.domain.usecases.voting;

import com.livmas.silo_web.domain.session.GameSession;
import com.livmas.silo_web.domain.session.SessionsManager;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.UUID;

@Component
public class GetAllVotesUseCase {
    SessionsManager sessionManager;

    public GetAllVotesUseCase(
            SessionsManager sessionManager
    ) {
        this.sessionManager = sessionManager;
    }

    public Map<Integer, Integer> execute(UUID roomId) {
        GameSession game = sessionManager.findGame(roomId);
        return game.getVotes();
    }
}