package com.livmas.silo_web.domain.session;

import com.livmas.silo_web.domain.models.PlayerModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

public class GameSession {
    private UUID roomId;

    public GameSession(UUID roomId, List<PlayerModel> players) {
        this.players = players;
        this.roomId = roomId;
    }

    public List<PlayerModel> players;

    public UUID getId() {
        return roomId;
    }
    public PlayerModel getPlayer(int index) {
        return players.get(index);
    }
}
