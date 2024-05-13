package com.livmas.silo_web.domain.session;

import com.livmas.silo_web.domain.models.PlayerModel;
import com.livmas.silo_web.domain.models.RoomVisitor;
import com.livmas.silo_web.domain.models.enums.GameStep;
import com.livmas.silo_web.domain.usecases.gameinfo.GetRandomCatastropheDtoUseCase;
import com.livmas.silo_web.domain.usecases.players.GetRandomPlayerModelUseCase;
import com.livmas.silo_web.mappers.GameInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class GameSessionFactory {
    GetRandomPlayerModelUseCase getRandomPlayerModelUseCase;
    GetRandomCatastropheDtoUseCase getRandomCatastropheDtoUseCase;

    @Autowired
    public GameSessionFactory(
            GetRandomPlayerModelUseCase getRandomPlayerModelUseCase,
            GetRandomCatastropheDtoUseCase getRandomCatastropheDtoUseCase
    ) {
        this.getRandomPlayerModelUseCase = getRandomPlayerModelUseCase;
        this.getRandomCatastropheDtoUseCase = getRandomCatastropheDtoUseCase;
    }


    public GameSession createSession(UUID roomId, List<RoomVisitor> roomVisitors) {
        AtomicInteger currPlayerId = new AtomicInteger(0);

        GameSession session = new GameSession(roomId);
        session.setPlayers(
                roomVisitors.stream().map(visitor -> {
                    PlayerModel player = getRandomPlayerModelUseCase.execute();
                    player.setName(visitor.name);
                    player.setId(currPlayerId.get());
                    currPlayerId.getAndIncrement();
                    return player;
                }).toList()
        );
        session.setTargetPlayersCount(
                roomVisitors.size() / 2
        );
        session.setStep(GameStep.PROPERTIES_OPENING);
        session.setBunker(null);

        session.setCatastrophe(
                GameInfoMapper.catastropheDtoToDomain(
                        getRandomCatastropheDtoUseCase.execute()
                )
        );

        return session;
    }
}
