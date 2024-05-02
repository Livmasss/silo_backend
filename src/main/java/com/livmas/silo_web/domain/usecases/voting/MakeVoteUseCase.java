package com.livmas.silo_web.domain.usecases.voting;

import com.livmas.silo_web.domain.exceptions.PlayerIsDeadException;
import com.livmas.silo_web.domain.exceptions.WrongStepException;
import com.livmas.silo_web.domain.models.PlayerModel;
import com.livmas.silo_web.domain.models.enums.GameStep;
import com.livmas.silo_web.domain.session.GameSession;
import com.livmas.silo_web.domain.session.GameSessionManager;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class MakeVoteUseCase {
    private final GameSessionManager gameSessionManager;
    public MakeVoteUseCase(
            GameSessionManager gameSessionManager
    ) {
        this.gameSessionManager = gameSessionManager;
    }
    public void execute(UUID roomId, int playerId, int targetId) throws WrongStepException, PlayerIsDeadException {
        try {
            GameSession game = gameSessionManager.findGame(roomId);

            if (game.getStep() != GameStep.VOTING)
                throw new WrongStepException();

            var alivePlayersIds = game.getAlivePlayers().stream().map(PlayerModel::getId).toList();
            if (!alivePlayersIds.contains(playerId))
                throw new PlayerIsDeadException();
            if (!alivePlayersIds.contains(targetId))
                throw new PlayerIsDeadException();

            game.getVotes().put(playerId, targetId);
        }
        catch (Exception ignored ) {

        }
    }
}
