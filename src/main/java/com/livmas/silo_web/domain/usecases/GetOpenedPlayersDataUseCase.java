package com.livmas.silo_web.domain;

import com.livmas.silo_web.domain.models.PlayerModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GetOpenedPlayersDataUseCase {
    public List<PlayerModel> execute() {
        List<PlayerModel> list = new ArrayList<>();

        list.add(
            new PlayerModel(
                "Зубослеп",
                "Мужчина",
                "",
                "",
                "Стоматолог",
                "",
                "",
                "Ящик пива",
                "",
                ""
        ));

        list.add(
            new PlayerModel(
                "Евгения",
                "Мужчина",
                "",
                "",
                "Гид по туалетам",
                "",
                "",
                "",
                "Работал в Росгвардии",
                ""
        ));

        list.add(
                new PlayerModel(
                    "Кринжеслав",
                    "Мужчина",
                    "Проблем нет",
                    "",
                    "Банкир",
                    "",
                    "",
                    "",
                    "",
                    ""
                ));

        return list;
    }
}
