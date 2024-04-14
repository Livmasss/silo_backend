package com.livmas.silo_web.domain.usecases;

import com.livmas.silo_web.domain.exceptions.PropertyAlreadyOpenedException;
import com.livmas.silo_web.domain.models.PlayerProperty;
import com.livmas.silo_web.domain.models.enums.PlayerPropertyName;
import com.livmas.silo_web.domain.session.SessionsManager;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class OpenPlayerPropertyUseCase {
    private final SessionsManager sessionsManager;

    public OpenPlayerPropertyUseCase(
            SessionsManager sessionsManager
    ) {
        this.sessionsManager = sessionsManager;
    }

    public void execute(UUID sessionId, int playerId, PlayerPropertyName propertyName) throws PropertyAlreadyOpenedException {
        PlayerProperty property = sessionsManager.findGame(sessionId).players.get(playerId).get(propertyName);
        if (property.isOpened())
            throw new PropertyAlreadyOpenedException();

        property.setOpened(true);
    }
}
