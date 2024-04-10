package com.amaap.cleanstrike.repository;

import com.amaap.cleanstrike.repository.exception.DuplicateIdException;

import java.util.HashSet;
import java.util.Set;


public class PlayerRepository {

    private Set<Integer> totalPlayers = new HashSet<>();

    public void insertPlayer(int playerOneId, int playerTwoId) throws DuplicateIdException {
        if (totalPlayers.contains(playerOneId) || totalPlayers.contains(playerTwoId)) {
            throw new DuplicateIdException("Duplicate player ID found.");
        }
        totalPlayers.add(playerOneId);
        totalPlayers.add(playerTwoId);
    }

    public Set<Integer> getTotalPlayers() {
        return totalPlayers;
    }
}
