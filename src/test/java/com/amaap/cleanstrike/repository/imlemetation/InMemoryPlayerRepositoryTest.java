package com.amaap.cleanstrike.repository.imlemetation;

import com.amaap.cleanstrike.repository.exception.DuplicateIdException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class InMemoryPlayerRepositoryTest {

    private InMemoryPlayerRepository playerRepository;

    @BeforeEach
    void setUp() {
        playerRepository = new InMemoryPlayerRepository();
    }

    @Test
    void shouldBeAbleToInsertPlayerSuccessfully() throws DuplicateIdException {
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
    void shouldNotBeAbleToInsertDuplicatePlayer() throws DuplicateIdException {
        // arrange
        int playerOneId = 1;
        int playerTwoId = 1;

        // act & assert
        playerRepository.insertPlayer(playerOneId, playerTwoId);

        // assert
        Set<Integer> totalPlayers = playerRepository.getTotalPlayers();
        assertEquals(1, totalPlayers.size());
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
