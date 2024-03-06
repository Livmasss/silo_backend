package com.livmas.silo_web.presenter.controllers;


import com.livmas.silo_web.domain.usecases.GetAllVotesUseCase;
import com.livmas.silo_web.domain.usecases.GetOpenedPlayersDataUseCase;
import com.livmas.silo_web.domain.usecases.GetPlayerDataUseCase;
import com.livmas.silo_web.presenter.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PlayerController {
    @Autowired
    public PlayerController(
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

    @GetMapping("/api/player_data")
    public PlayerResponse getPlayerData(/**@RequestBody PlayerRequest request**/) {
        return new PlayerResponse(
                getPlayerDataUseCase.execute(0, 0)
        );
    }

    @GetMapping("/api/players_open_data/{room_id}")
    public AllPlayersResponse getAllPlayersData(@PathVariable("room_id") int roomId, @RequestParam("player_id") int playerId) {
        return new AllPlayersResponse(
                getOpenedPlayersDataUseCase.execute(roomId).stream().map(
                        OpenedPlayerResponse::new
                ).toList()
        );
    }

    @GetMapping("/api/players_votes")
    public AllVotesResponse getActionsData() {
        return new AllVotesResponse(
                getAllVotesUseCase.execute(0, 0).stream().map(
                        PlayerVotesResponse::new
                ).toList()
        );
    }
}
