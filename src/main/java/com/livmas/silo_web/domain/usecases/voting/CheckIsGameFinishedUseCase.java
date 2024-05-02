package com.livmas.silo_web.domain.usecases.voting;

import com.livmas.silo_web.domain.exceptions.GameNotFoundException;
import com.livmas.silo_web.domain.session.GameSession;
import com.livmas.silo_web.domain.session.GameSessionManager;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class CheckIsGameFinishedUseCase {
    private GameSessionManager sessionManager;

    public boolean execute(UUID roomId) throws GameNotFoundException {
        GameSession game = sessionManager.findGame(roomId);
        return !game.hasExtraPlayers();
    }
}
