package com.livmas.silo_web.presentation.models.rest.responses;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.livmas.silo_web.domain.models.PlayerVotesModel;

import java.util.List;

public class PlayerVotesResponse {

    @JsonProperty("player_id")
    public int playerId;
    @JsonProperty("voted_players_ids")
    public List<Integer> votedPlayersIds;

    public PlayerVotesResponse(PlayerVotesModel model) {
        this.playerId = model.playerId;
        this.votedPlayersIds = model.votedPlayersIds;
    }
}
