/**
 * 
 */
package com.promineotech.batour.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;
import org.springframework.stereotype.Service;
import com.promineotech.batour.dao.BatourDao;
import com.promineotech.batour.entity.GameModel;
import com.promineotech.batour.entity.PlayerGameModel;
import com.promineotech.batour.entity.PlayerInputModel;
import com.promineotech.batour.entity.PlayerModel;
import com.promineotech.batour.entity.StateModel;

/**
 * @author 17015
 *
 */
@Service
public class DefaultBatourService implements BatourService {
  
  private BatourDao batourDao;
  
  public DefaultBatourService(BatourDao batourDao) {
    this.batourDao = batourDao;
  }

  @Override
  public List<GameModel> getGames() {
    Stream<GameModel> games = batourDao.getAllGames();
    return games.toList();
  }

  @Override
  public GameModel getGames(String gameAnotation) {
 // call data access layer
    if ((gameAnotation != null) && (! gameAnotation.isEmpty())){
     Optional<GameModel> game = batourDao.getGame(gameAnotation);
     if(game.isPresent()) {
       return game.get();
     }
    }
    return null;
    
    
  }

  @Override
  public PlayerModel getPlayers(String username) {
    if ((username != null) && (! username.isEmpty())) {
      Optional<PlayerModel> player = batourDao.getPlayer(username);
      if(player.isPresent()) {
        return player.get();
      }
    }
    return null;
  }

  @Override
  public List<PlayerModel> getPlayers() {
    Stream<PlayerModel> player = batourDao.getAllPlayers();
    return player.toList();
  }

  @Override
  public PlayerModel createPlayer(PlayerInputModel input) {
    if((input != null) && (input.isValid())) {
      Optional<PlayerModel> player = batourDao.createPlayer(input);
      if (player.isPresent()) {
        return player.get();
      }
    }
    return null;
  }

  @Override
  public PlayerModel deletePlayer(String username) {
    if((username != null)&&(! username.isEmpty())) {
      Optional<PlayerModel> player = batourDao.deletePlayer(username);
      if(player.isPresent()) {
        return player.get();
      }
    }
    return null;
  }

  @Override
  public PlayerModel updatePlayer(String username, PlayerModel input) {
    if((input != null) && (input.isValid())) {
      Optional<PlayerModel> players = batourDao.updatePlayer(username, input);
      if(players.isPresent()) {
        return players.get();
      }
    }
    return null;
  }

  @Override
  public List<StateModel> getStates() {
    Stream<StateModel> states = batourDao.getPlayerStates();
    return states.toList();
  }

  @Override
  public List<PlayerGameModel> getPlayerGames() {
    Stream<PlayerGameModel> pg = batourDao.getPlayerGames();
    return pg.toList();
  }
  

}
