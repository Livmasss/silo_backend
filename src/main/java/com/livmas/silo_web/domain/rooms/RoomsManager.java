package com.livmas.silo_web.domain.rooms;

import com.livmas.silo_web.domain.models.RoomVisitor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Component
public class RoomsManager {
//        this.roomId = UUID.randomUUID();

    public RoomsManager() {
        this.rooms = new HashMap<>();
    }

    private final Map<UUID, Room> rooms;

    public void createNewRoom() {
        rooms.put(UUID.randomUUID(), new Room());
    }

    public void connectToRoom(UUID roomId, String playerName) {
        rooms.get(roomId).addPlayer(
                new RoomVisitor(UUID.randomUUID(), playerName)
        );
    }
}