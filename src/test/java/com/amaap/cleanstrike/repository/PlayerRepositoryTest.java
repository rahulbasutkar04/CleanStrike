package com.amaap.cleanstrike.repository;

import com.amaap.cleanstrike.repository.exception.DuplicateIdException;
import com.amaap.cleanstrike.repository.imlemetation.InMemoryPlayerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PlayerRepositoryTest {

    private PlayerRepository playerRepository;

    @BeforeEach
    void setUp() {
        playerRepository = new InMemoryPlayerRepository();
    }

    @Test
    void shouldBeAbleToInsertPlayer() throws DuplicateIdException {
        // arrange
        int playerOneId = 1;
        int playerTwoId = 2;
        // act
        playerRepository.insertPlayer(playerOneId, playerTwoId);

        // assert
        Set<Integer> totalPlayers = playerRepository.getTotalPlayers();
        assertEquals(2, totalPlayers.size());
        assertTrue(totalPlayers.contains(playerOneId));
        assertTrue(totalPlayers.contains(playerTwoId));
    }

    @Test
    void shouldBeAbleToNotInsertDuplicatePlayer() throws DuplicateIdException {
        // arrange
        int playerOneId = 1;
        int playerTwoId = 1; // Duplicate ID

        // act & assert
        playerRepository.insertPlayer(playerOneId, playerTwoId);
        Set<Integer> totalPlayers = playerRepository.getTotalPlayers();
        assertEquals(1, totalPlayers.size(),"Duplicate player is not added");
    }

    @Test
    void shouldBeAbleToGetTotalPlayers() throws DuplicateIdException {
        // arrange
        int playerOneId = 1;
        int playerTwoId = 2;
        playerRepository.insertPlayer(playerOneId, playerTwoId);

        // act
        Set<Integer> totalPlayers = playerRepository.getTotalPlayers();

        // assert
        assertEquals(2, totalPlayers.size());
        assertTrue(totalPlayers.contains(playerOneId));
        assertTrue(totalPlayers.contains(playerTwoId));
    }
}
