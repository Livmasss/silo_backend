package com.livmas.silo_web.domain.session;

import com.livmas.silo_web.domain.session.usecases.GetRandomPlayerModelUseCase;
import com.livmas.silo_web.domain.models.PlayerModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GameSessionFactory {
    @Autowired
    public GameSessionFactory(GetRandomPlayerModelUseCase getRandomPlayerModelUseCase) {
        this.getRandomPlayerModelUseCase = getRandomPlayerModelUseCase;
    }

    private final GetRandomPlayerModelUseCase getRandomPlayerModelUseCase;
    public GameSession createGameSession(int players_count) {
        List<PlayerModel> players = new ArrayList<>();

        for (int i = 0; i < players_count; i++)
            players.add(getRandomPlayerModelUseCase.execute());

        return new GameSession(
                players
        );
    }
}
