package com.livmas.silo_web.presenter.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class PlayerActionsResponse {

    @JsonProperty("player_id")
    public int playerId;
    @JsonProperty("voted_players_ids")
    public List<Integer> votedPlayersIds;
    public String action;
}
