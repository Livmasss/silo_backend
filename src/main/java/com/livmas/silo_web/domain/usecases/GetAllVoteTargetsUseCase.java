package com.livmas.silo_web.domain.usecases;

import com.livmas.silo_web.domain.mappers.VotesMapper;
import com.livmas.silo_web.domain.models.PlayerVotesModel;
import com.livmas.silo_web.domain.session.GameSession;
import com.livmas.silo_web.domain.session.SessionsManager;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class GetAllVoteTargetsUseCase {
    SessionsManager sessionManager;

    public GetAllVoteTargetsUseCase(
            SessionsManager sessionManager
    ) {
        this.sessionManager = sessionManager;
    }

    public List<PlayerVotesModel> execute(UUID roomId) {
        GameSession game = sessionManager.findGame(roomId);

        if (!game.getVotes().isEmpty())
            return VotesMapper.mapToPlayerVotesModel(game.getVotes());

        return new ArrayList<>(
                game.getPlayers().stream().map(
                        p -> new PlayerVotesModel(p.getId(), new LinkedList<>())
                ).toList());
    }
}
