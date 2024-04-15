package com.livmas.silo_web.domain.session;

import com.livmas.silo_web.domain.models.PlayerModel;
import com.livmas.silo_web.domain.models.enums.GameStep;
import lombok.Getter;

import java.util.List;
import java.util.UUID;

@Getter
public class GameSession {
    private final UUID roomId;
    private int currentPlayerId = 0;
    private GameStep step = GameStep.NOT_STARTED;

    public GameSession(UUID roomId, List<PlayerModel> players) {
        this.players = players;
        this.roomId = roomId;
        this.step = GameStep.PROPERTIES_OPENING;
    }

    public final List<PlayerModel> players;

    public void nextTurn() {
        if (currentPlayerId + 1 != getPlayers().size())
            currentPlayerId = currentPlayerId + 1;
        else {
            currentPlayerId = 0;
            step = GameStep.VOTING;
        }
    }
    public PlayerModel getPlayer(int index) {
        return players.get(index);
    }
}
