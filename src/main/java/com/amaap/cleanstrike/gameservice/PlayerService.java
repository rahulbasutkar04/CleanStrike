package com.amaap.cleanstrike.service;

import com.amaap.cleanstrike.Http;
import com.amaap.cleanstrike.controller.dto.Response;
import com.amaap.cleanstrike.repository.PlayerRepository;
import com.amaap.cleanstrike.repository.exception.DuplicateIdException;

import java.util.Set;

public class PlayerService {


    private PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public Response validateToCreate(int playerOneId, int playerTwoId) throws DuplicateIdException {

        if (playerOneId <= 0 || playerTwoId <= 0) {
            return new Response(Http.BAD_REQUEST);
        } else {
            createPlayer(playerOneId, playerTwoId);
            return new Response(Http.OK);
        }
    }

    public void createPlayer(int id1, int id2) throws DuplicateIdException {
        playerRepository.insertPlayer(id1, id2);
    }


    public Set<Integer> getCreatedPlayer() {
        return playerRepository.getTotalPlayers();
    }
}
