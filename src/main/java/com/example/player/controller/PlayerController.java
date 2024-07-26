
package com.example.player;

import org.springframework.web.bind.annotation.*;
import org.springframework.bean.factory.annotation.Autowired;
import java.util.*;

import com.example.player.model.Player;
import com.example.player.service.playerH2Service;

@RestController
public class PlayerController {
   @Autowired
   private PlayerH2Service playerservice;

   @GetMapping("/players")
   public ArrayList<Player> getPlayers() {
      return playerservice.getPlayers();
   }

   @GetMapping("/players/{playerId}")
   public Player getPlayerById(@PathVariable("playerId") int playerId) {
      return playerservice.getPlayerById(playerId);
   }

   @PostMapping("/players")
   public Player addPlayer(@RequestBody Player player) {
      return playerservice.addPlayer(player);
   }

   @PutMapping("/players/{playerId}")
   public Player updatePlayer(@PathVariable("playerID") int playerId, @RequestBody Player player) {
      return playerservice.updatePlayer(playerId, player);
   }

   @DeleteMapping("/players/{playerId}")
   public void deletePlayer(@PathVariable("playerId") int playerId) {
      playerservice.deletePlayer(playerId);
   }
}
