package com.livmas.silo_web.presentation.models.ws;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.livmas.silo_web.presentation.models.rest.responses.PlayerVotesResponse;

import java.util.List;

public record VotingFinishedMessage(List<PlayerVotesResponse> items, @JsonProperty("game_finished") boolean isGameFinished) {
}
