package com.livmas.silo_web.domain.rooms;

import com.livmas.silo_web.domain.models.RoomVisitor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Room {
    private final List<RoomVisitor> players = new ArrayList<>();

    public void addPlayer(RoomVisitor roomVisitor) {
        players.add(roomVisitor);
    }

    public List<RoomVisitor> getVisitors() {
        return players;
    }
}
