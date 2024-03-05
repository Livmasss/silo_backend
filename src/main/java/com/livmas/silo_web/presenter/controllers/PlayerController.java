package com.livmas.silo_web.presenter.controllers;


import com.livmas.silo_web.domain.usecases.GetAllVotesUseCase;
import com.livmas.silo_web.domain.usecases.GetOpenedPlayersDataUseCase;
import com.livmas.silo_web.domain.usecases.GetPlayerDataUseCase;
import com.livmas.silo_web.presenter.models.*;
import org.springframework.web.bind.annotation.*;

@RestController
public class PlayerController {
    GetOpenedPlayersDataUseCase getOpenedPlayersDataUseCase = new GetOpenedPlayersDataUseCase();
    GetPlayerDataUseCase getPlayerDataUseCase = new GetPlayerDataUseCase();
    GetAllVotesUseCase getAllVotesUseCase = new GetAllVotesUseCase();

    @GetMapping("/api/player_data")
    public PlayerResponse getPlayerData(/**@RequestBody PlayerRequest request**/) {
        return new PlayerResponse(
                getPlayerDataUseCase.execute(0, 0)
        );
    }


    @GetMapping("/api/players_open_data")
    public AllPlayersResponse getAllPlayersData(/**@RequestBody PlayerRequest request**/) {
        return new AllPlayersResponse(
                getOpenedPlayersDataUseCase.execute(0).stream().map(
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
