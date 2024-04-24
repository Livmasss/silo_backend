package com.livmas.silo_web.domain.mappers;

import com.livmas.silo_web.domain.models.PlayerVotesModel;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class VotesMapper {
    private VotesMapper() {}
    public static List<PlayerVotesModel> mapToPlayerVotesModel(Map<Integer, Integer> map) {
        var result = new HashMap<Integer, List<Integer>>();

        map.keySet().forEach(key ->
                result.put(key, new LinkedList<>())
        );

        map.keySet().forEach(votedPlayer -> {
            var target = map.get(votedPlayer);
            result.get(target).add(votedPlayer);
        });

        return result.keySet().stream().map(key ->
                new PlayerVotesModel(key, result.get(key))
        ).toList();
    }
}
