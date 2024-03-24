package com.livmas.silo_web.communication.controllers;


import com.livmas.silo_web.domain.session.usecases.GetAllVotesUseCase;
import com.livmas.silo_web.domain.session.usecases.GetOpenedPlayersDataUseCase;
import com.livmas.silo_web.domain.session.usecases.GetPlayerDataUseCase;
import com.livmas.silo_web.communication.models.rest.responses.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PlayersController {
    @Autowired
    public PlayersController(
            GetOpenedPlayersDataUseCase getOpenedPlayersDataUseCase,
            GetPlayerDataUseCase getPlayerDataUseCase,
            GetAllVotesUseCase getAllVotesUseCase
    ) {
        this.getOpenedPlayersDataUseCase = getOpenedPlayersDataUseCase;
        this.getPlayerDataUseCase = getPlayerDataUseCase;
        this.getAllVotesUseCase = getAllVotesUseCase;
    }

    private final GetOpenedPlayersDataUseCase getOpenedPlayersDataUseCase;
    private final GetPlayerDataUseCase getPlayerDataUseCase;
    private final GetAllVotesUseCase getAllVotesUseCase;

    @GetMapping("/api/player_data/{room_id}")
    public PlayerResponse getPlayerData(@PathVariable("room_id") int roomId, @RequestParam("player_id") int playerId) {
        return new PlayerResponse(
                getPlayerDataUseCase.execute(roomId, playerId)
        );
    }

    @GetMapping("/api/players_open_data/{room_id}")
    public AllPlayersResponse getAllPlayersData(@PathVariable("room_id") int roomId) {
        return new AllPlayersResponse(
                getOpenedPlayersDataUseCase.execute(roomId).stream().map(
                        OpenedPlayerResponse::new
                ).toList()
        );
    }

    @GetMapping("/api/players_votes/{room_id}")
    public AllVotesResponse getActionsData(@PathVariable("room_id") int roomId) {
        return new AllVotesResponse(
                getAllVotesUseCase.execute(roomId).stream().map(
                        PlayerVotesResponse::new
                ).toList()
        );
    }

}
