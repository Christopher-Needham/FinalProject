/**
 * 
 */
package com.promineotech.batour.service;

import java.util.List;
import java.util.Optional;
import com.promineotech.batour.entity.GameModel;
import com.promineotech.batour.entity.PlayerGameModel;
import com.promineotech.batour.entity.PlayerInputModel;
import com.promineotech.batour.entity.PlayerModel;
import com.promineotech.batour.entity.StateModel;

/**
 * service layer for interacting with the components
 *
 */
public interface BatourService {
  /**
   * gets all available games
   * @return the games if found
   */
  List<GameModel> getGames();

  /**
   * Gets a game by its anotation
   * @param gameAnotation
   * @return the correct game if found, otherwise null
   */
  
  GameModel getGames(String gameAnotation);

  /**
   * @param username
   * @return
   */
  PlayerModel getPlayers(String username);

  /**
   * @return
   */
  List<PlayerModel> getPlayers();
  
  
  /**
   * creates new player
   * @param  the new player information
   * @return playerModel if successful, otherwise returns null
   */
  PlayerModel createPlayer(PlayerInputModel input);

  /**
   * @param username
   * @return
   */
  PlayerModel deletePlayer(String username);

  /**
   * @param username 
   * @param input
   * @return
   */
  PlayerModel updatePlayer(String username, PlayerModel input);

  /**
   * @return
   */
  List<StateModel> getStates();

  /**
   * @return
   */
  List<PlayerGameModel> getPlayerGames();



}
