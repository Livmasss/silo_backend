package com.livmas.silo_web.models;

import java.util.ArrayList;
import java.util.List;

public class AllPlayersResponse {
    public AllPlayersResponse(ArrayList<PlayerResponse> content) {
        players = content;
    }

    private final List<PlayerResponse> players;
    public List<PlayerResponse> getPlayers() {
        return players;
    }
}