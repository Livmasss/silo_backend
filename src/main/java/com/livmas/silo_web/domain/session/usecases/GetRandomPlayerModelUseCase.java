package com.livmas.silo_web.domain.session.usecases;

import com.livmas.silo_web.domain.models.PlayerModel;
import org.springframework.stereotype.Component;

@Component
public class GetRandomPlayerModelUseCase {
    public PlayerModel execute() {
        return new PlayerModel(
                10,
                null,
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
