package com.livmas.silo_web.domain.rooms;

import com.livmas.silo_web.domain.exceptions.RoomNotFoundException;
import com.livmas.silo_web.domain.models.RoomVisitor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Component
public class RoomsManager {

    public RoomsManager() {
        this.rooms = new HashMap<>();
    }

    private final Map<UUID, Room> rooms;

    public UUID createNewRoom(String roomCreator) {
        UUID id = UUID.randomUUID();
        rooms.put(id, new Room());
        rooms.get(id).addPlayer(new RoomVisitor(UUID.randomUUID(), roomCreator));
        return id;
    }

    public void connectToRoom(UUID roomId, String playerName) throws RoomNotFoundException {
        try {
            rooms.get(roomId).addPlayer(
                    new RoomVisitor(UUID.randomUUID(), playerName)
            );
        }
        catch (NullPointerException e) {
            throw new RoomNotFoundException();
        }
    }

    public List<RoomVisitor> readRoomVisitors(UUID roomId) {
        return rooms.get(roomId).getVisitors();
    }

    public Room getRoom(UUID roomId) {
        return rooms.get(roomId);
    }
}