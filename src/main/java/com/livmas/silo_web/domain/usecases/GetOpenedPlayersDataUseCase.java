package com.livmas.silo_web.domain.usecases;

import com.livmas.silo_web.domain.models.OpenedPlayerModel;
import com.livmas.silo_web.domain.models.PlayerModel;
import com.livmas.silo_web.domain.models.enums.PlayerPropertyName;
import com.livmas.silo_web.domain.session.SessionsManager;
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
        List<PlayerModel> player = sessionsManager.findGame(roomId).players;

        for (PlayerModel playerModel : player) {
            list.add(
                    new OpenedPlayerModel(
                            playerModel.getName(),
                            playerModel.getOpenedContent(PlayerPropertyName.GENDER),
                            playerModel.getOpenedContent(PlayerPropertyName.HEALTH),
                            playerModel.getOpenedContent(PlayerPropertyName.PERSONALITY),
                            playerModel.getContent(PlayerPropertyName.PROFESSION),
                            playerModel.getOpenedContent(PlayerPropertyName.HOBBY),
                            playerModel.getContent(PlayerPropertyName.PHOBIA),
                            playerModel.getOpenedContent(PlayerPropertyName.INVENTORY),
                            playerModel.getOpenedContent(PlayerPropertyName.INFORMATION),
                            playerModel.getOpenedContent(PlayerPropertyName.ACTION)
                    ));
        }
        return list;
    }
}
