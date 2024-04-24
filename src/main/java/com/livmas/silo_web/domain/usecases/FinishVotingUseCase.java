package com.livmas.silo_web.domain.usecases;

import com.livmas.silo_web.domain.exceptions.NotAllVotesException;
import com.livmas.silo_web.domain.exceptions.WrongStepException;
import com.livmas.silo_web.domain.mappers.VotesMapper;
import com.livmas.silo_web.domain.models.PlayerModel;
import com.livmas.silo_web.domain.models.PlayerVotesModel;
import com.livmas.silo_web.domain.models.enums.GameStep;
import com.livmas.silo_web.domain.session.GameSession;
import com.livmas.silo_web.domain.session.SessionsManager;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

@Component
public class FinishVotingUseCase {
    private final SessionsManager sessionsManager;
    private final GetAllVotesUseCase getAllVotesUseCase;
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

        for (PlayerModel p : session.getAlivePlayers()) {
            if (!votes.containsKey(p.getId())) {
                throw new NotAllVotesException();
            }
        }

        List<PlayerVotesModel> targetVotes = VotesMapper.mapToPlayerVotesModel(votes);
        var sortedVotes = new LinkedList<>(targetVotes.stream().sorted(Comparator.comparingInt(PlayerVotesModel::getVotedPlayersCount)).toList());
        var playerToKill = sortedVotes.getLast();

        LoggerFactory.getLogger(FinishVotingUseCase.class).info("Killed player: %s in room %s".formatted(playerToKill.getPlayerId(), session.getRoomId()));

        session.killPlayer(playerToKill.getPlayerId());
        session.finishVoting();
        session.nextTurn();
    }
}
