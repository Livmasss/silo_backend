package com.livmas.silo_web.domain.models;

import java.util.List;

public class PlayerVotesModel {

    public int playerId;
    public List<Integer> votedPlayersIds;

    public PlayerVotesModel(int playerId, List<Integer> votedPlayersIds) {
        this.playerId = playerId;
        this.votedPlayersIds = votedPlayersIds;
    }
}
