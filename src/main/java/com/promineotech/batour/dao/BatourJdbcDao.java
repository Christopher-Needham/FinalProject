package com.promineotech.batour.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;
import org.springframework.boot.context.config.ConfigData.Options;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;
import com.promineotech.batour.entity.GameModel;
import com.promineotech.batour.entity.PlayerGameModel;
import com.promineotech.batour.entity.PlayerInputModel;
import com.promineotech.batour.entity.PlayerModel;
import com.promineotech.batour.entity.StateModel;

/**
 * An implementation of the BatourDao using mysql and Jdbc
 */

@Repository
public class BatourJdbcDao implements BatourDao {

  private NamedParameterJdbcTemplate provider;

  public BatourJdbcDao(NamedParameterJdbcTemplate provider) {
    this.provider = provider;
  }


  /**
   * converts a result set into an instance of game model
   * 
   * @paramrs the result set or the current row
   * @param rowNum the current row
   * @return the created game model
   */
  private GameModel toGameModel(ResultSet rs, int rowNum) {
    GameModel game;
    try {
      game = new GameModel(rs.getString("games_anotation"), rs.getString("games_date"));
      return game;
    } catch (SQLException e) {
      return null;
    }
  }


  private StateModel toStateModel(ResultSet rs, int rowNum) {
    StateModel states;
    try {
      states = new StateModel(rs.getString("username"), rs.getString("group_concat(state_name)"));
      return states;
    } catch (SQLException e) {
      return null;
    }
  }

  private PlayerGameModel toPlayerGameModel(ResultSet rs, int rowNum) {
    PlayerGameModel pg;
    try {
      pg = new PlayerGameModel(rs.getString("games_anotation"), rs.getString("games_date"),
          rs.getString("group_concat(username)"));
      return pg;
    } catch (SQLException e) {
      return null;
    }
  }


  private PlayerModel toPlayerModel(ResultSet rs, int rowNum) {
    PlayerModel player;
    try {
      player =
          new PlayerModel(rs.getString("username"), rs.getInt("age"), rs.getString("date_birth"));
      return player;
    } catch (SQLException e) {
      return null;
    }
  }

  @Override
  public Stream<GameModel> getAllGames() {

    String sql = "SELECT games_anotation, games_date " + "FROM games;";
    Map<String, Object> parameters = new HashMap<>();

    List<GameModel> games = provider.query(sql, parameters, (rs, rowNum) -> {
      GameModel game = toGameModel(rs, rowNum);
      return game;
    });

    return games.stream();

  }

  @Override
  public Optional<GameModel> getGame(String gameAnotation) {
    if ((gameAnotation != null) && (!gameAnotation.isEmpty())) {
      String sql = "SELECT games_anotation, games_date " + "FROM games "
          + "WHERE games_anotation = :game_anotation;";
      Map<String, Object> parameters = new HashMap<>();
      parameters.put("game_anotation", gameAnotation);
      List<GameModel> games = provider.query(sql, parameters, (rs, rowNum) -> {
        return toGameModel(rs, rowNum);
      });
      if (games.size() >= 1) {
        return Optional.of(games.get(0));

      }


    }
    return Optional.empty();
  }


  @Override
  public Optional<PlayerModel> getPlayer(String username) {
    if ((username != null) && (!username.isEmpty())) {
      String sql =
          "SELECT username, age, date_birth " + "FROM player " + "WHERE username = :username;";
      Map<String, Object> parameters = new HashMap<>();
      parameters.put("username", username);
      List<PlayerModel> player = provider.query(sql, parameters, (rs, rowNum) -> {
        return toPlayerModel(rs, rowNum);
      });
      if (player.size() >= 1) {
        return Optional.of(player.get(0));

      }


    }
    return Optional.empty();
  }


  @Override
  public Stream<PlayerModel> getAllPlayers() {
    String sql = "SELECT username, age, date_birth " + "FROM player;";
    Map<String, Object> parameters = new HashMap<>();

    List<PlayerModel> players = provider.query(sql, parameters, (rs, rowNum) -> {
      PlayerModel player = toPlayerModel(rs, rowNum);
      return player;
    });

    return players.stream();
  }


  /**
   * creates model
   * 
   * @param input
   * @return playerModel if successful or nothing if false.
   */
  public Optional<PlayerModel> createPlayer(PlayerInputModel input) {
    String existing = input.getUsername();
    Optional<PlayerModel> check = getPlayer(existing);
    if (!check.isPresent()) {
      if ((input != null) && (input.isValid())) {
        String sql = "INSERT INTO player (username, date_birth, age) "
            + "VALUES (:username, :date_birth, :age);";
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("username", input.getUsername());
        parameters.put("date_birth", input.getDate_birth());
        parameters.put("age", input.getAge());

        int rows = provider.update(sql, parameters);
        if (rows == 1) {
          return getPlayer(input.getUsername());
        }


      }
      return Optional.empty();
    }
    throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
        String.format("Invalid Player. Value: %s", existing));

  }


  @Override
  public Optional<PlayerModel> deletePlayer(String username) {
    Optional<PlayerModel> existing = getPlayer(username);
    if (existing.isPresent()) {
      String sql = "DELETE FROM player" + " WHERE username = :username;";
      Map<String, Object> parameters = new HashMap<>();
      parameters.put("username", existing.get().getUsername());

      int rows = provider.update(sql, parameters);
      if (rows == 1) {
        return existing;
      }

    }
    return Optional.empty();
  }


  @Override
  public Optional<PlayerModel> updatePlayer(String username, PlayerModel input) {
    Optional<PlayerModel> existing = getPlayer(username);
    if (existing.isPresent()) {
      if ((input != null) && (input.isValid())) {

        String sql =
            "UPDATE player " + "SET age = :age, date_birth = :date_birth, username = :userName "
                + "WHERE username = :username;";
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("username", username);
        parameters.put("userName", input.getUsername());
        parameters.put("date_birth", input.getDate_birth());
        parameters.put("age", input.getAge());

        int rows = provider.update(sql, parameters);
        if (rows == 1) {
          return getPlayer(input.getUsername());
        }


      }
      return Optional.empty();
    }
    throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
        String.format("Invalid Player. (jdbc dao) Value: %s", existing));
  }


  @Override
  public Stream<StateModel> getPlayerStates() {
    String sql = "SELECT username, group_concat(state_name) " + "FROM player p"
        + "    INNER JOIN states s  on" + "    p.player_pk = s.player_fk"
        + "    GROUP BY username;";

    Map<String, Object> parameters = new HashMap<>();

    List<StateModel> states = provider.query(sql, parameters, (rs, rowNum) -> {
      StateModel state = toStateModel(rs, rowNum);
      return state;
    });

    return states.stream();
  }


  @Override
  public Stream<PlayerGameModel> getPlayerGames() {
    String sql = "select games_anotation, games_date, group_concat(username)" + "    from games g"
        + "    join player_games pg on g.games_pk = pg.games_fk"
        + "    join player p on p.player_pk = pg.player_fk" + "    group by games_anotation;";

    Map<String, Object> parameters = new HashMap<>();

    List<PlayerGameModel> pgs = provider.query(sql, parameters, (rs, rowNum) -> {
      PlayerGameModel pg = toPlayerGameModel(rs, rowNum);
      return pg;
    });
    return pgs.stream();
  }

/**
 * @param rs
 * @param rowNum
 * @return
 */
}


