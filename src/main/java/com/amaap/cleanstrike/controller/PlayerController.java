package com.amaap.cleanstrike.controller;

import com.amaap.cleanstrike.controller.dto.Response;
import com.amaap.cleanstrike.repository.exception.DuplicateIdException;
import com.amaap.cleanstrike.service.PlayerService;


public class PlayerController {
    PlayerService playerService;
    public Response createPlayers(int playerOneId, int playerTwoId) throws DuplicateIdException {
          return playerService.validateToCreate(playerOneId,playerTwoId);
    }
}
