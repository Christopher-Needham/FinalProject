/**
 * 
 */
package com.promineotech.batour.entity;

import lombok.Builder;
import lombok.Data;

/**
 * @author 17015
 *
 */
public class GameModel {
  
  private long game_pk;
  private String gameAnotation;
  private String date;
  
  
  /**
   * @return the gamePK
   */
  
  
  public GameModel(String gameAnotation, String date) {
    setDate(date);
    setGameAnotation(gameAnotation);
  }

  /**
   * @return the gameInformation
   */
  public String getGameAnotation() {
    return gameAnotation;
  }
  /**
   * @param gameInformation the gameInformation to set
   */
  public void setGameAnotation(String gameAnotation) {
    this.gameAnotation = gameAnotation;
  }
  /**
   * @return the date
   */
  public String getDate() {
    return date;
  }
  /**
   * @param date the date to set
   */
  public void setDate(String date) {
    this.date = date;
  }

  

}
