
package com.example.player;
  import com.example.player.model.Player;
  import com.example.player.repository.PlayerRepository;


  import org.springframework.beans.factory.annotation.Autowired;
  import org.springframework.http.HttpStatus;
  import org.springframework.jdbc.core.JdbcTemplate;
  import org.springframework.stereotype.Service;
  import org.springframework.web.server.ResponseStatusException;
  import java.util.ArrayList;
  
 

@Service 
public PlayerH2Service implements PlayerRepository{
    @Autowired 
    private JdbcTemplate db;

    @Override 
    public ArrayList<Player> getPlayers(){
        return (ArrayList<Player>) db.query("select * from team",new playerRowMapper());
    }
    @Override
    public Player getPlayerById(int playerId){
        try{
            return db.queryForObject("select * from team where playerId=? ",new playerRowMapper(),playerId);
        }
        catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        }
    }
    @Override 
    public Player addPlayer(Player player){
        db.update("inser into team (playerName,jerseyNumber,role) values(?,?,?)",player.getplayerName(),
        player.getjerseyNumber(),player.getrole());
        return db.queryForObject("select * from team where playerName=?,jerseyNumber=?" new playerRowMapper(),
        player.getplayerName(),player.getjerseyNumber());
    }

    @Override 
    public void deletePlayer(int playerId){
        db.update("delete from team where playerId=?" playerId);
    }

    @Override 
    public Player updatePlayer(int playerId,Player player){
        if(player.getplayerName()!=null){
            db.update("update team set playerName=? where playerId=?",player.getplayerName(),playerId);
        }
        if(player.getjerseyNumber()!=0){
            db.update("update team set jerseyNumber=? where playerId=?",player.getjerseyNumber(),playerId);
        }
        if(player.getrole()!=null){
            db.update("update team set role=? where playerId=?",player.getrole(),playerId);
        }
        return getPlayerById(playerId);
        
    }

}