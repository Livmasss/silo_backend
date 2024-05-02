package com.livmas.silo_web.domain.usecases.players;

import com.livmas.silo_web.domain.models.OpenedPlayerModel;
import com.livmas.silo_web.domain.models.PlayerModel;
import com.livmas.silo_web.domain.session.GameSessionManager;
import com.livmas.silo_web.presentation.mappers.PlayerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Component
public class GetOpenedPlayersDataUseCase {
    @Autowired
    public GetOpenedPlayersDataUseCase(GameSessionManager gameSessionManager) {
        this.gameSessionManager = gameSessionManager;
    }

    private final GameSessionManager gameSessionManager;

    public List<OpenedPlayerModel> execute(UUID roomId) {
        List<OpenedPlayerModel> list = new ArrayList<>();
        try {
            List<PlayerModel> players = gameSessionManager.findGame(roomId).getAlivePlayers();

            for (PlayerModel playerModel : players) {
                list.add(
                        PlayerMapper.openedResponseFromModel(playerModel));
            }
            return list;
        }
        catch (Exception e) {
            return Collections.emptyList();
        }
    }
}
