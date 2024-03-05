package com.livmas.silo_web.controllers;


import com.livmas.silo_web.models.PlayerRequest;
import com.livmas.silo_web.models.PlayerResponse;
import org.springframework.web.bind.annotation.*;

@RestController
public class PlayerController {
    @GetMapping("/player")
    public PlayerResponse getPlayerData(@RequestBody PlayerRequest request) {
        return new PlayerResponse(
            "Мужчина",
            "Спид",
            "Уверенный",
            "Гид по туалетам",
            "Геймер",
            "Клоунофобия",
            "Виагра",
            "Работал в Росгвардии",
            "В этом голосовании ваш голос считается за 2"
        );
    }


    @GetMapping("/players")
    public PlayerResponse getAllPlayersData(@RequestBody PlayerRequest request) {
        return new PlayerResponse(
                "Мужчина",
                "Спид",
                "Уверенный",
                "Гид по туалетам",
                "Геймер",
                "Клоунофобия",
                "Виагра",
                "Работал в Росгвардии",
                "В этом голосовании ваш голос считается за 2"
        );
    }
}
