package com.livmas.silo_web.presentation.controllers.user;


import com.livmas.silo_web.domain.usecases.players.GetOpenedPlayersDataUseCase;
import com.livmas.silo_web.domain.usecases.players.GetPlayerDataUseCase;
import com.livmas.silo_web.domain.usecases.players.GetPlayerIdUseCase;
import com.livmas.silo_web.presentation.mappers.PlayerMapper;
import com.livmas.silo_web.presentation.models.rest.responses.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class PlayerRestController {
    @Autowired
    public PlayerRestController(
            GetOpenedPlayersDataUseCase getOpenedPlayersDataUseCase,
            GetPlayerDataUseCase getPlayerDataUseCase,
            GetPlayerIdUseCase getPlayerIdUseCase
    ) {
        this.getOpenedPlayersDataUseCase = getOpenedPlayersDataUseCase;
        this.getPlayerDataUseCase = getPlayerDataUseCase;
        this.getPlayerIdUseCase = getPlayerIdUseCase;
    }

    private final GetOpenedPlayersDataUseCase getOpenedPlayersDataUseCase;
    private final GetPlayerDataUseCase getPlayerDataUseCase;
    private final GetPlayerIdUseCase getPlayerIdUseCase;

    @GetMapping("/api/player_data/{room_id}")
    public PlayerResponse getPlayerData(@PathVariable("room_id") UUID roomId, @RequestParam("player_id") Integer playerId) {
        return new PlayerResponse(
                getPlayerDataUseCase.execute(roomId, playerId)
        );
    }

    @GetMapping("/api/player_id/{room_id}")
    public int getPlayerId(@PathVariable("room_id") UUID roomId, @RequestParam("player_name") String name) {
        return getPlayerIdUseCase.execute(roomId, name);
    }

    @GetMapping("/api/players_open_data/{room_id}")
    public AllPlayersResponse getAllPlayersData(@PathVariable("room_id") UUID roomId) {

        return new AllPlayersResponse(
                getOpenedPlayersDataUseCase.execute(roomId).stream().map(
                        PlayerMapper::openedResponseFromOpenedModel
                ).toList()
        );
    }
}
