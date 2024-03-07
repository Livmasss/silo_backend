package com.livmas.silo_web;

import com.livmas.silo_web.domain.session.GameSession;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedList;
import java.util.List;

@Configuration
public class SpringConfiguration {
    @Bean
    public List<GameSession> gameSessions() {
        return new LinkedList<>();
    }
}
