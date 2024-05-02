package com.livmas.silo_web.domain.usecases.voting;

import com.livmas.silo_web.domain.session.GameSession;
import com.livmas.silo_web.domain.session.GameSessionManager;
import java.util.Collections;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.UUID;

@Component
public class GetAllVotesUseCase {
    GameSessionManager sessionManager;

    public GetAllVotesUseCase(
            GameSessionManager sessionManager
    ) {
        this.sessionManager = sessionManager;
    }

    public Map<Integer, Integer> execute(UUID roomId) {
        try {
            GameSession game = sessionManager.findGame(roomId);
            return game.getVotes();
        }
        catch (Exception e) {
            return Collections.emptyMap();
        }
    }
}
