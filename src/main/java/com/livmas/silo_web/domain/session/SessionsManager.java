package com.livmas.silo_web.domain.session;

import com.livmas.silo_web.domain.models.PlayerModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class SessionsManager {

    @Autowired
    public SessionsManager(List<GameSession> sessions) {
        this.sessions = sessions;
    }

    private final List<GameSession> sessions;

    public void createNewSession(GameSession session) {
        sessions.add(session);
    }

    public PlayerModel getSessionPlayerData(UUID roomId, int playerIndex) {
        GameSession game = findGame(roomId);
        assert game != null;
        return game.getPlayer(playerIndex);
    }

    public int getPlayerIdByName(UUID roomId, String name) {
        try {
            GameSession game = findGame(roomId);
            PlayerModel player = game.players.stream().filter(p -> p.name.equals(name)).findFirst().orElse(null);

            return game.players.lastIndexOf(player);
        }
        catch (Exception e) {
            return -1;
        }
    }

    private GameSession findGame(UUID roomId) {
        var gamesById = sessions.stream().filter(x -> x.getId().equals(roomId));
        return gamesById.findFirst().orElse(null);
    }
}
