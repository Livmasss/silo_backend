package com.livmas.silo_web.domain.usecases;

import com.livmas.silo_web.domain.models.PlayerModel;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetRandomPlayerModelUseCase {

    private int i = 0;

    public PlayerModel execute() {

        return switch (i++ % 3) {
            case 0 -> new PlayerModel(
                    10,
                    "Зубослеп",
                    List.of(
                            "Мужчина",
                            "Спид",
                            "Уверенный",
                            "Гид по туалетам",
                            "Геймер",
                            "Клоунофобия",
                            "Виагра",
                            "Работал в Росгвардии",
                            "В этом голосовании ваш голос считается за 2"
                    )
            );
            case 1 -> new PlayerModel(
                    10,
                    "Евгения",
                    List.of(
                            "Женщина",
                            "Идеально здоров",
                            "Интроверт",
                            "Студент",
                            "Настольные игры",
                            "Нет фобий",
                            "Ремонтный набор",
                            "Было 10 кошек",
                            "Поменяться карточками здоровья с любым игроком"
                    )
            );
            default -> new PlayerModel(
                    10,
                    "Кринжеслав",
                    List.of(
                        "Мужчина",
                        "Дерматит",
                        "Кринжовый",
                        "Клоун",
                        "Кулинария",
                        "Тетрафобия",
                        "Кошачий корм",
                        "Гомофоб",
                        "Уменьшить количество еды в бункере в 2 раза"
                    )
            );
        };
    }
}
