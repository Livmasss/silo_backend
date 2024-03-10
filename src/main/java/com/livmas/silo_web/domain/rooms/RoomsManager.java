package com.livmas.silo_web.domain.rooms;

import com.livmas.silo_web.domain.models.RoomVisitor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Component
public class RoomsManager {

    public RoomsManager() {
        this.rooms = new HashMap<>();
    }

    private final Map<UUID, Room> rooms;

    public UUID createNewRoom() {
        UUID id = UUID.randomUUID();
        rooms.put(id, new Room());
        return id;
    }

    public void connectToRoom(UUID roomId, String playerName) {
        rooms.get(roomId).addPlayer(
                new RoomVisitor(UUID.randomUUID(), playerName)
        );
    }
}