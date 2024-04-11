package com.amaap.cleanstrike.controller;

import com.amaap.cleanstrike.Http;
import com.amaap.cleanstrike.controller.dto.Response;
import com.amaap.cleanstrike.gameservice.PlayerService;
import com.amaap.cleanstrike.repository.exception.DuplicateIdException;
import com.amaap.cleanstrike.repository.imlemetation.InMemoryPlayerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerControllerTest {
    private PlayerController playerController;
    private PlayerService playerService;

    @BeforeEach
    void setUp() {
        InMemoryPlayerRepository playerRepository = new InMemoryPlayerRepository();
        playerService = new PlayerService(playerRepository);
        playerController = new PlayerController(playerService);
    }

    @Test
    void shouldBeAbleTORespondWithOkWhenPlayerISCreatedWithId() throws DuplicateIdException {
        // arrange
        int playerOneId = 1;
        int playerTwoId = 2;

        Response expected = new Response(Http.OK);

        // act
        Response actual = playerController.createPlayers(playerOneId, playerTwoId);

        // assert
        assertEquals(expected, actual);
    }

    @Test
    void shouldBeAbleTORespondWithBadRequestWhenPlayerISCreatedWithInvalidId() throws DuplicateIdException {
        // arrange
        int playerOneId = -1;
        int playerTwoId = 2;

        Response expected = new Response(Http.BAD_REQUEST);

        // act
        Response actual = playerController.createPlayers(playerOneId, playerTwoId);

        // assert
        assertEquals(expected, actual);
    }
}
