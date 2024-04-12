package com.amaap.cleanstrike.controller;

import com.amaap.cleanstrike.controller.dto.Response;
import com.amaap.cleanstrike.gameservice.GameService;
import com.amaap.cleanstrike.gameservice.PlayerService;

public class GameController {
    private final PlayerService playerService;
    GameService gameService=new GameService();

    public GameController(PlayerService playerService) {
        this.playerService = playerService;
    }

    public Response getPlayers() {

        return gameService.getPlayers(playerService);
    }
}
