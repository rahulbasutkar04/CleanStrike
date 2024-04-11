package com.amaap.cleanstrike.repository.database.implementation;

import com.amaap.cleanstrike.repository.database.Database;

import java.util.HashSet;
import java.util.Set;

public class InMemoryDatabase implements Database {
    private Set<Integer> totalPlayers = new HashSet<>();
    @Override
    public void insertPlayers(int id1, int id2) {
        totalPlayers.add(id1);
        totalPlayers.add(id2);

    }

    @Override
    public Set<Integer> getPlayer() {
        return totalPlayers;
    }
}
