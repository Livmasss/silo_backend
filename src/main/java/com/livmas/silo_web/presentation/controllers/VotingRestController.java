package com.livmas.silo_web.presentation.controllers;

import com.livmas.silo_web.domain.usecases.voting.MakeVoteUseCase;
import com.livmas.silo_web.presentation.models.rest.requests.MakeVoteRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class VotingRestController {
    private final MakeVoteUseCase makeVoteUseCase;
    private final Logger logger = LoggerFactory.getLogger(VotingRestController.class);

    public VotingRestController(
            MakeVoteUseCase makeVoteUseCase
    ) {
        this.makeVoteUseCase = makeVoteUseCase;
    }

    @PostMapping("/api/vote/{room_id}")
    public void makeVote(@PathVariable("room_id") UUID roomId, @RequestBody MakeVoteRequest request) {
        try {
            makeVoteUseCase.execute(roomId, request.playerId(), request.targetId());
            logger.info("Vote occurred in session %s: %s -> %s".formatted(roomId, request.playerId(), request.targetId()));
        }
        catch (Exception e) {
            logger.warn(e.toString());
        }
    }
}
