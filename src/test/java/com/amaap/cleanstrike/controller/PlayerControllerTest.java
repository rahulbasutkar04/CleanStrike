package com.amaap.cleanstrike.controller;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerControllerTest {

    @Test
    void shouldBeAbleTORespondWithOkWhenPlayerISCreatedWithId()
    {
        // arrange
        int playerOneId=1;
        int playerTwoId=2;
        PlayerController playerController=new PlayerController();

        Response expected=new Response(Http.OK);
        // act
        Response actual= playerController.createPlayers(playerOneId,playerTwoId);

        // assert
        assertEquals(expected,actual);
    }
}
