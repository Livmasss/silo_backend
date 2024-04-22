package com.livmas.silo_web.domain.usecases;

import com.livmas.silo_web.domain.models.PlayerVotesModel;
import com.livmas.silo_web.domain.session.GameSession;
import com.livmas.silo_web.domain.session.SessionsManager;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

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

        var votesModel = new HashMap<Integer, List<Integer>>();
        game.getPlayers().forEach(p ->
            votesModel.put(p.getId(), new LinkedList<>())
        );

        game.getVotes().keySet().forEach(votedPlayer -> {
            var target = game.getVotes().get(votedPlayer);
            votesModel.get(target).add(votedPlayer);
        });

        return votesModel.keySet().stream().map(key ->
                new PlayerVotesModel(key, votesModel.get(key))
        ).toList();
    }
}
