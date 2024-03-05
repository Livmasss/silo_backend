package com.livmas.silo_web.domain.usecases;

import com.livmas.silo_web.domain.models.OpenedPlayerModel;

import java.util.ArrayList;
import java.util.List;

public class GetOpenedPlayersDataUseCase {
    public List<OpenedPlayerModel> execute(int room_id) {
        List<OpenedPlayerModel> list = new ArrayList<>();

        list.add(
            new OpenedPlayerModel(
                "Зубослеп",
                "Мужчина",
                "",
                "",
                "Стоматолог",
                "",
                "",
                "Ящик пива",
                "",
                "Обменяться картами рофессий с любым игроком"
        ));

        list.add(
            new OpenedPlayerModel(
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
                new OpenedPlayerModel(
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
