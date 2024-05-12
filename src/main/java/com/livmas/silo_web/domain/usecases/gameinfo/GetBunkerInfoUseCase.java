package com.livmas.silo_web.domain.usecases.gameinfo;

import com.livmas.silo_web.domain.exceptions.GameNotFoundException;
import com.livmas.silo_web.domain.models.BunkerModel;
import com.livmas.silo_web.domain.session.GameSessionManager;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class GetBunkerInfoUseCase {
    GameSessionManager sessionManager;

    public BunkerModel execute(UUID gameId) throws GameNotFoundException {
        return sessionManager.findGame(gameId).getBunker();
    }
}
