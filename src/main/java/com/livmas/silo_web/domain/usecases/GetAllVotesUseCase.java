package com.livmas.silo_web.domain.usecases;

import com.livmas.silo_web.domain.models.PlayerVotesModel;
import com.livmas.silo_web.domain.session.GameSession;
import com.livmas.silo_web.domain.session.SessionsManager;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class GetAllVotesUseCase {
    SessionsManager sessionManager;

    public GetAllVotesUseCase(
            SessionsManager sessionManager
    ) {
        this.sessionManager = sessionManager;
    }

    public List<PlayerVotesModel> execute(UUID roomId) {
        GameSession game = sessionManager.findGame(roomId);

        return game.getVotes().keySet().stream().map(key ->
                new PlayerVotesModel(key, game.getVotes().get(key))
        ).toList();
    }
}
