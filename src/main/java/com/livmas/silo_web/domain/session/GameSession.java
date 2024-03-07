package com.livmas.silo_web.domain.session;

import com.livmas.silo_web.domain.models.PlayerModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GameSession {
    @Autowired
    public GameSession(List<PlayerModel> players) {
        this.players = players;
    }

    private List<PlayerModel> players;
}
