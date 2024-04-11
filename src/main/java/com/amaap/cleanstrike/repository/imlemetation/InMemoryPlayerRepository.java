package com.amaap.cleanstrike.repository.imlemetation;

import com.amaap.cleanstrike.repository.PlayerRepository;
import com.amaap.cleanstrike.repository.database.implementation.InMemoryDatabase;
import com.amaap.cleanstrike.repository.exception.DuplicateIdException;

import java.util.HashSet;
import java.util.Set;

public class InMemoryPlayerRepository implements PlayerRepository {
    InMemoryDatabase inMemoryDatabase=new InMemoryDatabase();
    private Set<Integer> totalPlayers = inMemoryDatabase.getPlayer();

    @Override
    public void insertPlayer(int playerOneId, int playerTwoId) throws DuplicateIdException {
        if (totalPlayers.contains(playerOneId) || totalPlayers.contains(playerTwoId)) {
            throw new DuplicateIdException("Duplicate player ID found.");
        }
        inMemoryDatabase.insertPlayers(playerOneId,playerTwoId);

    }

    @Override
    public Set<Integer> getTotalPlayers() {
        return inMemoryDatabase.getPlayer();
    }
}
