package com.amaap.cleanstrike.controller;

import com.amaap.cleanstrike.controller.dto.Response;
import com.amaap.cleanstrike.repository.exception.DuplicateIdException;
import com.amaap.cleanstrike.gameservice.PlayerService;


public class PlayerController {

    private PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }
    public Response createPlayers(int playerOneId, int playerTwoId) throws DuplicateIdException {
          return playerService.validateToCreate(playerOneId,playerTwoId);
    }
}
