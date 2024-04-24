package com.livmas.silo_web.domain.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PlayerVotesModel {

    private int playerId;
    private List<Integer> votedPlayersIds;

    public PlayerVotesModel(int playerId, List<Integer> votedPlayersIds) {
        this.playerId = playerId;
        this.votedPlayersIds = votedPlayersIds;
    }

    public int getVotedPlayersCount() {
        return votedPlayersIds.size();
    }
}
