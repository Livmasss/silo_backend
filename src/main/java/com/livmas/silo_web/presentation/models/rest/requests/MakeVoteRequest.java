package com.livmas.silo_web.presentation.models.rest.requests;

import com.fasterxml.jackson.annotation.JsonProperty;


public record MakeVoteRequest(
        @JsonProperty("player_id")
        int playerId,
        @JsonProperty("target_id")
        int targetId
) {}