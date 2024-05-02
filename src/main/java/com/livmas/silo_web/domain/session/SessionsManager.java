package com.livmas.silo_web.domain.session;

import com.livmas.silo_web.domain.exceptions.GameNotFoundException;
import com.livmas.silo_web.domain.models.PlayerModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
        try {
            GameSession game = findGame(roomId);
            assert game != null;
            return game.getPlayer(playerIndex);
        }
        catch (Exception e){
            return null;
        }
    }

    public int getPlayerIdByName(UUID roomId, String name) {
        try {
            GameSession game = findGame(roomId);
            PlayerModel player = game.getPlayers().stream().filter(p ->
                p.getName().equals(name)
            ).findFirst().orElse(null);

            return game.getPlayers().lastIndexOf(player);
        }
        catch (Exception e) {
            return -1;
        }
    }

    public GameSession findGame(UUID roomId) throws GameNotFoundException {
        var gamesById = sessions.stream().filter(x -> x.getRoomId().equals(roomId));
        var game = gamesById.findFirst();

        if (game.isEmpty())
            throw new GameNotFoundException();

        return game.orElse(null);
    }
}
