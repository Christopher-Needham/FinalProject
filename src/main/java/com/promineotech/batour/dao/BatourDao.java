/**
 * 
 */
package com.promineotech.batour.dao;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;
import com.promineotech.batour.entity.GameModel;
import com.promineotech.batour.entity.PlayerGameModel;
import com.promineotech.batour.entity.PlayerInputModel;
import com.promineotech.batour.entity.PlayerModel;
import com.promineotech.batour.entity.StateModel;

/**
 * Retrieves all games in database
 * @return the games
 *
 */
public interface BatourDao {
  
  Stream<GameModel> getAllGames();

  /**
   * gets a game by its anotation
   * @param gameAnotation
   * @return the game if found, otherwise an empty optional
   */
  Optional<GameModel> getGame(String gameAnotation);

  /**
   * @param username
   * @return
   */
  Optional<PlayerModel> getPlayer(String username);

  /**
   * @return
   */
  Stream<PlayerModel> getAllPlayers();
  
  
  /**
   * creates new player
   * @param  the new player information
   * @return playerModel if successful, otherwise an empty optional
   */
  Optional<PlayerModel> createPlayer(PlayerInputModel input);

  /**
   * @param username
   * @return
   */
  Optional<PlayerModel> deletePlayer(String username);

  /**
   * @param username 
   * @param player
   * @return
   */
  Optional<PlayerModel> updatePlayer(String username, PlayerModel input);

  /**
   * @return
   */
  Stream<StateModel> getPlayerStates();

  /**
   * @return
   */
  Stream<PlayerGameModel> getPlayerGames();



  
}


