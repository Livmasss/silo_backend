package com.livmas.silo_web.presentation.controllers.ws;

import com.livmas.silo_web.domain.exceptions.GameNotFoundException;
import com.livmas.silo_web.domain.usecases.voting.CheckIsGameFinishedUseCase;
import com.livmas.silo_web.domain.usecases.voting.FinishVotingUseCase;
import com.livmas.silo_web.domain.usecases.voting.GetAllVoteTargetsUseCase;
import com.livmas.silo_web.presentation.models.rest.responses.PlayerVotesResponse;
import com.livmas.silo_web.presentation.models.ws.VotingFinishedMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.util.UUID;

@Controller
public class VotingWSController {

    private final FinishVotingUseCase finishVotingUseCase;
    private final GetAllVoteTargetsUseCase getAllVoteTargetsUseCase;
    private final CheckIsGameFinishedUseCase checkIsGameFinishedUseCase;

    private final Logger logger = LoggerFactory.getLogger(VotingWSController.class);

    @Autowired
    public VotingWSController(FinishVotingUseCase finishVotingUseCase, GetAllVoteTargetsUseCase getAllVoteTargetsUseCase, CheckIsGameFinishedUseCase checkIsGameFinishedUseCase) {
        this.finishVotingUseCase = finishVotingUseCase;
        this.getAllVoteTargetsUseCase = getAllVoteTargetsUseCase;
        this.checkIsGameFinishedUseCase = checkIsGameFinishedUseCase;
    }

    @MessageMapping("/game/finish_voting/{room_id}")
    @SendTo("/game/voting_finished/{room_id}")
    public VotingFinishedMessage finishVoting(@DestinationVariable("room_id") UUID roomId) {
        try {
            finishVotingUseCase.execute(roomId);
            logger.info("Voting finishing in session %s".formatted(roomId));
        }
        catch (Exception e) {
            logger.warn(e.toString());
        }

        boolean isFinished = false;

        try {
            isFinished = checkIsGameFinishedUseCase.execute(roomId);
        } catch (GameNotFoundException ignored) {
        }

        return new VotingFinishedMessage(
                getAllVoteTargetsUseCase.execute(roomId).stream().map(
                        PlayerVotesResponse::new
                ).toList(),
                isFinished
        );
    }
}
