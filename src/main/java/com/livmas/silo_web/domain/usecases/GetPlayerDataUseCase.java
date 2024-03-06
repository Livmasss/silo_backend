package com.livmas.silo_web.domain.usecases;

import com.livmas.silo_web.domain.models.PlayerModel;
import org.springframework.stereotype.Component;

@Component
public class GetPlayerDataUseCase {
    public PlayerModel execute(int player_id, int room_id) {
        return new PlayerModel(
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
