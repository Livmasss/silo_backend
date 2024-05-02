package com.livmas.silo_web.domain.session;

import com.livmas.silo_web.domain.exceptions.OpeningRoundFinishedException;
import com.livmas.silo_web.domain.exceptions.PropertyAlreadyOpenedException;
import com.livmas.silo_web.domain.models.PlayerModel;
import com.livmas.silo_web.domain.models.PlayerProperty;
import com.livmas.silo_web.domain.models.enums.GameStep;
import com.livmas.silo_web.domain.models.enums.PlayerPropertyName;
import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class GameSession {
    private final UUID roomId;
    private int currentPlayerId = 0;
    private GameStep step;
    private final List<PlayerModel> players;
    private final int targetPlayersCount;
    private HashMap<Integer, Integer> votes = createVotesMap();
    private Logger logger = LoggerFactory.getLogger(GameSession.class);

    public GameSession(UUID roomId, List<PlayerModel> players, int targetPlayersCount) {
        this.players = players;
        this.roomId = roomId;
        this.targetPlayersCount = targetPlayersCount;
        this.step = GameStep.PROPERTIES_OPENING;
    }

    public void nextTurn() {
        try {
            goToNextAlivePlayer();
        }
        catch (OpeningRoundFinishedException e) {
            if (hasExtraPlayers()) {
                step = GameStep.VOTING;
                currentPlayerId = -1;
                logger.info("Voting started in room: %s".formatted(roomId));
            }
        }
    }

    public boolean hasExtraPlayers() {
        return getAlivePlayers().size() > targetPlayersCount;
    }

    public List<PlayerModel> getAlivePlayers() {
        return players.stream().filter(
                PlayerModel::getIsAlive
        ).toList();
    }
    public void finishVoting() {
        if (hasExtraPlayers()) {
            votes.clear();
            step = GameStep.PROPERTIES_OPENING;
            return;
        }

        step = GameStep.FINISHED;
        logger.info("Game finished: %s".formatted(roomId));
    }

    public void killPlayer(int playerId) {
        players.get(playerId).setIsAlive(false);
    }

    public void openProperty(int playerId, PlayerPropertyName propertyName) throws PropertyAlreadyOpenedException {
        PlayerProperty property = players.get(playerId).get(propertyName);
        if (property.isOpened())
            throw new PropertyAlreadyOpenedException();

        property.setOpened(true);
    }

    private void goToNextAlivePlayer() throws OpeningRoundFinishedException {
        try {
            currentPlayerId++;
            while (Boolean.FALSE.equals(players.get(currentPlayerId).getIsAlive()))
                currentPlayerId++;
            logger.info("Next player to open property: %s".formatted(currentPlayerId));
        }
        catch (ArrayIndexOutOfBoundsException e) {
            throw new OpeningRoundFinishedException();
        }
    }
    public PlayerModel getPlayer(int index) {
        return players.get(index);
    }

    private HashMap<Integer, Integer> createVotesMap() {
        return new HashMap<>();
    }
}
