package com.amaap.cleanstrike.repository.database;

import java.util.Set;

public interface Database {

     void insertPlayers(int id1, int id2);

     Set<Integer> getPlayer();

}
