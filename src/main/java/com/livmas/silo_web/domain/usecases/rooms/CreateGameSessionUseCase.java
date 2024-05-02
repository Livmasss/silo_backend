package com.livmas.silo_web.domain.usecases.rooms;

import com.livmas.silo_web.domain.exceptions.NotEnoughPlayersException;
import com.livmas.silo_web.domain.rooms.RoomsManager;
import com.livmas.silo_web.domain.session.GameSessionFactory;
import com.livmas.silo_web.domain.session.GameSessionManager;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Properties;
import java.util.UUID;

@AllArgsConstructor(onConstructor = @__(@Autowired))
@Component
public class CreateGameSessionUseCase {
    GameSessionManager sessionManager;
    RoomsManager roomsManager;
    GameSessionFactory gameSessionFactory;

    public void execute(UUID roomId) throws NotEnoughPlayersException {
        var visitors = roomsManager.getRoom(roomId).getVisitors();
        int minPlayersCount = 3;

        try {
            Properties props = getProps();
            try {
                String value = (String) props.get("min-players-count-to-start");
                minPlayersCount = Integer.parseInt(value);
            }
            catch (Exception ignored) {

            }
        } catch (IOException ignored) {

        }

        if (visitors.size() < minPlayersCount)
            throw new NotEnoughPlayersException();

        sessionManager.createNewSession(
                gameSessionFactory.createSession(
                        roomId, visitors
                )
        );
    }

    Properties getProps() throws IOException {
        Properties props = new Properties();
        props.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("config.properties"));
        return props;
    }
}
