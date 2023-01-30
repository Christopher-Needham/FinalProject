/**
 * 
 */
package com.promineotech.batour.entity;

/**
 * @author 17015
 *
 */
public class PlayerGameModel {
  private Long games_pk;
  private String games_anotation;
  private String games_date;
  private String username;
  
    public PlayerGameModel (String games_anotation, String games_date, String username) {
      setGames_anotation(games_anotation);
      setGames_date(games_date);
      setUsername(username);
    }

  /**
   * @return the games_anotation
   */
  public String getGames_anotation() {
    return games_anotation;
  }
  /**
   * @param games_anotation the games_anotation to set
   */
  public void setGames_anotation(String games_anotation) {
    this.games_anotation = games_anotation;
  }
  /**
   * @return the games_date
   */
  public String getGames_date() {
    return games_date;
  }
  /**
   * @param games_date the games_date to set
   */
  public void setGames_date(String games_date) {
    this.games_date = games_date;
  }
  /**
   * @return the username
   */
  public String getUsername() {
    return username;
  }
  /**
   * @param username the username to set
   */
  public void setUsername(String username) {
    this.username = username;
  }
  
  

}
