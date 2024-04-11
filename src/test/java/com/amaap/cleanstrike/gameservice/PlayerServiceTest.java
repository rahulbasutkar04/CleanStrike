package com.amaap.cleanstrike.gameservice;

import com.amaap.cleanstrike.repository.exception.DuplicateIdException;

import com.amaap.cleanstrike.repository.imlemetation.InMemoryPlayerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PlayerServiceTest {
    private PlayerService playerService;
    private InMemoryPlayerRepository playerRepository;

    @BeforeEach
    void setUp() {
        playerRepository = new InMemoryPlayerRepository(); // Using the actual implementation
        playerService = new PlayerService(playerRepository);
    }

    @Test
    void shouldBeAbleToCreatePlayer() throws DuplicateIdException {
        // arrange
        int playerOneId = 1;
        int playerTwoId = 2;

        // act
        playerService.createPlayer(playerOneId, playerTwoId);

        // assert
        Set<Integer> createdPlayers = playerService.getCreatedPlayer();
        assertEquals(2, createdPlayers.size());
        assertTrue(createdPlayers.contains(playerOneId));
        assertTrue(createdPlayers.contains(playerTwoId));
    }

    @Test
    void shouldBeAbleToCreatePlayerDuplicateInput() throws DuplicateIdException {
        // arrange
        int playerOneId = 1;
        int playerTwoId = 1;

        // act
        playerService.createPlayer(playerOneId, playerTwoId);

        // assert
        Set<Integer> totalPlayers = playerService.getCreatedPlayer();
        assertEquals(1, totalPlayers.size());
    }
}
