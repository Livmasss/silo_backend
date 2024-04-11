package com.livmas.silo_web.domain.session;

import com.livmas.silo_web.domain.models.PlayerModel;

import java.util.List;
import java.util.UUID;

public class GameSession {
    private final UUID roomId;

    public GameSession(UUID roomId, List<PlayerModel> players) {
        this.players = players;
        this.roomId = roomId;
    }

    public final List<PlayerModel> players;

    public UUID getId() {
        return roomId;
    }
    public PlayerModel getPlayer(int index) {
        return players.get(index);
    }
}
