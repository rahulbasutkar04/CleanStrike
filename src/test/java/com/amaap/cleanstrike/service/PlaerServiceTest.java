package com.amaap.cleanstrike.service;

import com.amaap.cleanstrike.repository.PlayerRepository;
import com.amaap.cleanstrike.repository.exception.DuplicateIdException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PlaerServiceTest {


    private PlayerService playerService;
    private PlayerRepository playerRepository;

    @BeforeEach
    void setUp() {
        playerRepository = new PlayerRepository();
        playerService = new PlayerService();
        playerService.playerRepository = playerRepository;
    }

    @Test
    void shouldBeAbleToCreatePlayer() throws DuplicateIdException {
        // Arrange
        int playerOneId = 1;
        int playerTwoId = 2;

        // Act
        playerService.createPlayer(playerOneId, playerTwoId);

        // Assert
        Set<Integer> createdPlayers = playerService.getCreatedPlayer();
        assertEquals(2, createdPlayers.size());
        assertTrue(createdPlayers.contains(playerOneId));
        assertTrue(createdPlayers.contains(playerTwoId));
    }

    @Test
    void shouldBeAbleToCreatePlayerDuplicateInput() throws DuplicateIdException {
        // Arrange
        int playerOneId = 1;
        int playerTwoId = 1;

        // Act
        playerService.createPlayer(playerOneId, playerTwoId);

        // Assert
        Set<Integer> totalPlayers = playerService.getCreatedPlayer();
        assertEquals(1, totalPlayers.size());
    }


}