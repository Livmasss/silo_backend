package com.livmas.silo_web.presentation.models.rest.responses;

import java.util.List;

public class AllPlayersResponse {
    public AllPlayersResponse(List<OpenedPlayerResponse> content) {
        players = content;
    }

    private final List<OpenedPlayerResponse> players;
    public List<OpenedPlayerResponse> getPlayers() {
        return players;
    }
}