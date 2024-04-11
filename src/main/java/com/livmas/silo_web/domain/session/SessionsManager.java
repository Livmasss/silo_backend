package com.livmas.silo_web.domain.session;

import com.livmas.silo_web.domain.models.PlayerModel;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class SessionsManager {

    @Autowired
    public SessionsManager(List<GameSession> sessions, ApplicationContext context) {
        this.sessions = sessions;
    }

    private final List<GameSession> sessions;

    public void createNewSession(GameSession session) {
        sessions.add(session);
    }
    public PlayerModel getPlayerDataSession(UUID roomId, int playerIndex) {
        var gamesById = sessions.stream().filter(x -> x.getId().equals(roomId));
        GameSession game = gamesById.findFirst().orElse(null);

        assert game != null;
        return game.getPlayer(playerIndex);
    }
}
