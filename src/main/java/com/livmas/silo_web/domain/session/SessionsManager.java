package com.livmas.silo_web.domain.session;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SessionsManager {

    @Autowired
    public SessionsManager(List<GameSession> sessions, ApplicationContext context) {
        this.sessions = sessions;
    }

    private final List<GameSession> sessions;

    public void createNewSession() {
        sessions.add(new GameSession(new ArrayList<>()));
    }
}
