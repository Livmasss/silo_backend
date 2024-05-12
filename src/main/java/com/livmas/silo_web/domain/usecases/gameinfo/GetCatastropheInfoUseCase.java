package com.livmas.silo_web.domain.usecases.gameinfo;

import com.livmas.silo_web.domain.exceptions.GameNotFoundException;
import com.livmas.silo_web.domain.models.CatastropheModel;
import com.livmas.silo_web.domain.session.GameSessionManager;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@AllArgsConstructor(onConstructor = @__(@Autowired))
@Component
public class GetCatastropheInfoUseCase {
    private GameSessionManager sessionManager;

    public CatastropheModel execute(UUID gameId) throws GameNotFoundException {
        return sessionManager.findGame(gameId).getCatastrophe();
    }
}
