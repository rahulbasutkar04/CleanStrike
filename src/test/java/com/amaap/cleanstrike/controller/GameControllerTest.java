package com.amaap.cleanstrike.controller;

import com.amaap.cleanstrike.Http;
import com.amaap.cleanstrike.controller.dto.Response;
import com.amaap.cleanstrike.gameservice.PlayerService;
import com.amaap.cleanstrike.repository.PlayerRepository;
import com.amaap.cleanstrike.repository.imlemetation.InMemoryPlayerRepository;
import com.amaap.cleanstrike.repository.exception.DuplicateIdException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GameControllerTest {
    private GameController gameController;
    private PlayerService playerService;

    @BeforeEach
    void setUp() {
        PlayerRepository playerRepository = new InMemoryPlayerRepository();
        playerService = new PlayerService(playerRepository);
        gameController = new GameController(playerService);
    }

    @Test
    void shouldBeAbleToGetThePlayerIdToStartTheGameAndRespondWithOk() throws DuplicateIdException {
        // arrange
        int playerOneId = 1;
        int playerTwoId = 2;
        playerService.validateToCreate(playerOneId,playerTwoId);
        Response expected=new Response(Http.OK);
        // act
        Response actual = gameController.getPlayers();

        // assert
        assertEquals(expected, actual);
    }
}
