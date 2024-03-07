package com.livmas.silo_web.domain.usecases;

import com.livmas.silo_web.domain.models.PlayerModel;
import org.springframework.stereotype.Component;

@Component
public class GetPlayerDataUseCase {
    public PlayerModel execute(int room_id, int player_id) {
        return new PlayerModel(
                10,
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
