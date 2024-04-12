package com.amaap.cleanstrike.gameservice;

import com.amaap.cleanstrike.Http;
import com.amaap.cleanstrike.controller.dto.Response;
import com.amaap.cleanstrike.repository.PlayerRepository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GameService {
    private final PlayerService playerService;
    private final Set<Integer> playerIds = new HashSet<>();

    // Constructor
    public GameService(PlayerRepository playerRepository) {
        this.playerService = new PlayerService(playerRepository);
    }

    public Response getPlayers(PlayerService playerService) {
        playerIds.addAll(playerService.getCreatedPlayer());
        if(playerIds.isEmpty()) {
            return new Response(Http.BAD_REQUEST);
        }
        return new Response(Http.OK);
    }

    public Set<Integer> getCreatedPlayer() {
        return playerIds;
    }
}


