package com.example.player;

import java.util.*;
import com.example.player.repository;

interface PlayerRepository {
     ArrayList<Player> getPlayers();

     Player getPlayerById(int playerId);

     Player addPlayer(Player player);

     Player updatePlayer(int playerId, Player player);

     void deletePlayer(int playerId);

}