package com.livmas.silo_web.presentation.controllers;


import com.livmas.silo_web.domain.usecases.GetAllVotesUseCase;
import com.livmas.silo_web.domain.usecases.GetOpenedPlayersDataUseCase;
import com.livmas.silo_web.domain.usecases.GetPlayerDataUseCase;
import com.livmas.silo_web.domain.usecases.GetPlayerIdUseCase;
import com.livmas.silo_web.presentation.models.rest.responses.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class PlayersController {
    @Autowired
    public PlayersController(
            GetOpenedPlayersDataUseCase getOpenedPlayersDataUseCase,
            GetPlayerDataUseCase getPlayerDataUseCase,
            GetPlayerIdUseCase getPlayerIdUseCase,
            GetAllVotesUseCase getAllVotesUseCase
    ) {
        this.getOpenedPlayersDataUseCase = getOpenedPlayersDataUseCase;
        this.getPlayerDataUseCase = getPlayerDataUseCase;
        this.getPlayerIdUseCase = getPlayerIdUseCase;
        this.getAllVotesUseCase = getAllVotesUseCase;
    }

    private final GetOpenedPlayersDataUseCase getOpenedPlayersDataUseCase;
    private final GetPlayerDataUseCase getPlayerDataUseCase;
    private final GetPlayerIdUseCase getPlayerIdUseCase;
    private final GetAllVotesUseCase getAllVotesUseCase;

    @GetMapping("/api/player_data/{room_id}")
    public PlayerResponse getPlayerData(@PathVariable("room_id") UUID roomId, @RequestParam("player_id") int playerId) {
        return new PlayerResponse(
                getPlayerDataUseCase.execute(roomId, playerId)
        );
    }

    @GetMapping("/api/player_id/{room_id}")
    public int getPlayerId(@PathVariable("room_id") UUID roomId, @RequestParam("player_id") String name) {
        return getPlayerIdUseCase.execute(roomId, name);
    }

    @GetMapping("/api/players_open_data/{room_id}")
    public AllPlayersResponse getAllPlayersData(@PathVariable("room_id") UUID roomId) {
        return new AllPlayersResponse(
                getOpenedPlayersDataUseCase.execute(roomId).stream().map(
                        OpenedPlayerResponse::new
                ).toList()
        );
    }

    @GetMapping("/api/players_votes/{room_id}")
    public AllVotesResponse getActionsData(@PathVariable("room_id") UUID roomId) {
        return new AllVotesResponse(
                getAllVotesUseCase.execute(roomId).stream().map(
                        PlayerVotesResponse::new
                ).toList()
        );
    }
}
