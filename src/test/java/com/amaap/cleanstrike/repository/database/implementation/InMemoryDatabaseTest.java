package com.amaap.cleanstrike.repository.database.implementation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class InMemoryDatabaseTest {

    private InMemoryDatabase database;

    @BeforeEach
    void setUp() {
        database = new InMemoryDatabase();
    }

    @Test
    void shouldBeAbleToInsertPlayersSuccessfully() {
        // arrange
        int playerOneId = 1;
        int playerTwoId = 2;

        // act
        database.insertPlayers(playerOneId, playerTwoId);

        // assert
        Set<Integer> totalPlayers = database.getPlayer();
        assertEquals(2, totalPlayers.size());
        assertTrue(totalPlayers.contains(playerOneId));
        assertTrue(totalPlayers.contains(playerTwoId));
    }

    @Test
    void shouldNotBeAbleToInsertDuplicatePlayers() {
        // arrange
        int playerOneId = 1;
        int playerTwoId = 1; // Duplicate ID

        // act
        database.insertPlayers(playerOneId, playerTwoId);

        // assert
        Set<Integer> totalPlayers = database.getPlayer();
        assertEquals(1, totalPlayers.size());
        assertTrue(totalPlayers.contains(playerOneId));
    }

    @Test
    void shouldBeAbleToGetTotalPlayers() {
        // arrange
        int playerOneId = 1;
        int playerTwoId = 2;
        database.insertPlayers(playerOneId, playerTwoId);

        // act
        Set<Integer> totalPlayers = database.getPlayer();

        // assert
        assertEquals(2, totalPlayers.size());
        assertTrue(totalPlayers.contains(playerOneId));
        assertTrue(totalPlayers.contains(playerTwoId));
    }
}
