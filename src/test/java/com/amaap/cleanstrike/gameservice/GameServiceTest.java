package com.amaap.cleanstrike.gameservice;

import com.amaap.cleanstrike.repository.PlayerRepository;
import com.amaap.cleanstrike.repository.exception.DuplicateIdException;
import com.amaap.cleanstrike.repository.imlemetation.InMemoryPlayerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GameServiceTest {

    private PlayerRepository playerRepository;
    private GameService gameService;

    @BeforeEach
    void setUp() {
        playerRepository = new InMemoryPlayerRepository();
        gameService = new GameService(playerRepository);
    }

    @Test
    void shouldBeAbleToGetTheCreatedPlayerIdsToStartTheGame() throws DuplicateIdException {
        // arrange
        PlayerService playerService = new PlayerService(playerRepository);
        playerService.validateToCreate(1, 2);
        gameService.getPlayers(playerService);

        Set<Integer> expected = new HashSet<>();
        expected.add(1);
        expected.add(2);

        // act
        Set<Integer> actual = gameService.getCreatedPlayer();

        // assert
        assertEquals(expected, actual);
    }
}

