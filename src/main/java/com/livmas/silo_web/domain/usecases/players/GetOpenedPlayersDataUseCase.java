package com.livmas.silo_web.domain.usecases.players;

import com.livmas.silo_web.domain.models.OpenedPlayerModel;
import com.livmas.silo_web.domain.models.PlayerModel;
import com.livmas.silo_web.domain.session.SessionsManager;
import com.livmas.silo_web.presentation.mappers.PlayerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class GetOpenedPlayersDataUseCase {
    @Autowired
    public GetOpenedPlayersDataUseCase(SessionsManager sessionsManager) {
        this.sessionsManager = sessionsManager;
    }

    private final SessionsManager sessionsManager;

    public List<OpenedPlayerModel> execute(UUID roomId) {
        List<OpenedPlayerModel> list = new ArrayList<>();
        List<PlayerModel> players = sessionsManager.findGame(roomId).getAlivePlayers();

        for (PlayerModel playerModel : players) {
            list.add(
                    PlayerMapper.openedResponseFromModel(playerModel));
        }
        return list;
    }
}
