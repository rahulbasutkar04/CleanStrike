package com.amaap.cleanstrike.repository;

import com.amaap.cleanstrike.repository.exception.DuplicateIdException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

    public interface PlayerRepository {
        void insertPlayer(int playerOneId, int playerTwoId) throws DuplicateIdException;
        Set<Integer> getTotalPlayers();
    }

