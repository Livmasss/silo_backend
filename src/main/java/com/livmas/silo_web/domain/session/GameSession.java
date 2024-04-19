package com.livmas.silo_web.domain.session;

import com.livmas.silo_web.domain.exceptions.OpenPropertyInForeignTurnException;
import com.livmas.silo_web.domain.exceptions.PropertyAlreadyOpenedException;
import com.livmas.silo_web.domain.models.PlayerModel;
import com.livmas.silo_web.domain.models.PlayerProperty;
import com.livmas.silo_web.domain.models.enums.GameStep;
import com.livmas.silo_web.domain.models.enums.PlayerPropertyName;
import lombok.Getter;
import lombok.Setter;

import java.util.*;

@Getter
@Setter
public class GameSession {
    private final UUID roomId;
    private int currentPlayerId = 0;
    private GameStep step = GameStep.NOT_STARTED;
    public final List<PlayerModel> players;
    private HashMap<Integer, List<Integer>> votes = new HashMap<>();

    public GameSession(UUID roomId, List<PlayerModel> players) {
        this.players = players;
        this.roomId = roomId;
        this.step = GameStep.PROPERTIES_OPENING;

        players.forEach( i->
                votes.put(i.getId(), new LinkedList<>())
        );
    }

    public void nextTurn() {
        if (currentPlayerId + 1 != getPlayers().size())
            currentPlayerId = currentPlayerId + 1;
        else {
            currentPlayerId = 0;
            step = GameStep.VOTING;
        }
    }

    public void openProperty(int playerId, PlayerPropertyName propertyName) throws PropertyAlreadyOpenedException {
        PlayerProperty property = players.get(playerId).get(propertyName);
        if (property.isOpened())
            throw new PropertyAlreadyOpenedException();

        property.setOpened(true);
    }

    public PlayerModel getPlayer(int index) {
        return players.get(index);
    }
}
