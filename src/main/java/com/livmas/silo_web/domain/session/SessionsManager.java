package com.livmas.silo_web.domain.session;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SessionsManager {

    public SessionsManager(List<GameSession> sessions) {
        this.sessions = sessions;
    }

    private List<GameSession> sessions;
}
