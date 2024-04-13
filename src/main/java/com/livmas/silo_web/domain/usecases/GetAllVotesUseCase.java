package com.livmas.silo_web.domain.usecases;

import com.livmas.silo_web.domain.models.PlayerVotesModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class GetAllVotesUseCase {
    public List<PlayerVotesModel> execute(UUID roomId) {
        List<PlayerVotesModel> list = new ArrayList<>();

        List<Integer> votes0 = new ArrayList<>(1);
        votes0.add(1);
        votes0.add(2);

        List<Integer> votes1 = new ArrayList<>(1);
        votes1.add(0);

        list.add(
                new PlayerVotesModel(
                        0, votes0
                )
        );

        list.add(
                new PlayerVotesModel(
                        1, votes1
                )
        );

        list.add(
                new PlayerVotesModel(
                        2, new ArrayList<>()
                )
        );

        return list;
    }
}

//
//[
//        {
//        "player": "Зубослеп",
//        "votes": [
//        "Евгения",
//        "Кринжеслав"
//        ],
//        "action": ""
//        },
//        {
//        "player": "Евгения",
//        "votes": [],
//        "action": "Уменьшает запасы еды в бункере на 24"
//        },
//        {
//        "player": "Кринжеслав",
//        "votes": [
//        "Зубослеп"
//        ],
//        "action": ""
//        }]
