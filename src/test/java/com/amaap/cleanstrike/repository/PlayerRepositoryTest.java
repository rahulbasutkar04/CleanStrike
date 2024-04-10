package com.amaap.cleanstrike.repository;

import com.amaap.cleanstrike.repository.exception.DuplicateIdException;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class PlayerRepositoryTest {


    private PlayerRepository playerRepository=new PlayerRepository();


    @Test
    void shouldInsertPlayer() throws DuplicateIdException {
        // arrange
        int playerOneId = 1;
        int playerTwoId = 2;

        // Act
        playerRepository.insertPlayer(playerOneId, playerTwoId);

        // Assert
        Set<Integer> totalPlayers = playerRepository.getTotalPlayers();
        assertEquals(2, totalPlayers.size());
        assertTrue(totalPlayers.contains(playerOneId));
        assertTrue(totalPlayers.contains(playerTwoId));
    }

    @Test
    void shouldNotInsertDuplicatePlayer() {
        // arrange
        int playerOneId = 1;
        int playerTwoId = 1; // Duplicate ID

        // act & assert
        DuplicateIdException exception = assertThrows(DuplicateIdException.class, () -> {
            playerRepository.insertPlayer(playerOneId, playerTwoId);
        });
        assertEquals("Duplicate player ID found.", exception.getMessage());
        Set<Integer> totalPlayers = playerRepository.getTotalPlayers();
        assertEquals(0, totalPlayers.size());
    }

    @Test
    void shouldGetTotalPlayers() throws DuplicateIdException {
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