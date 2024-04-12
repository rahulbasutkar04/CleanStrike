package com.amaap.cleanstrike.gameservice;

import com.amaap.cleanstrike.Http;
import com.amaap.cleanstrike.controller.dto.Response;
import com.amaap.cleanstrike.repository.PlayerRepository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GameService {
       PlayerRepository playerRepository;
       PlayerService playerService=new PlayerService(playerRepository);
       Set<Integer> playerIds=new HashSet<>();
    public Response getPlayers(PlayerService playerService) {

       playerIds= playerService.getCreatedPlayer();

        return new Response(Http.OK);
    }
}


