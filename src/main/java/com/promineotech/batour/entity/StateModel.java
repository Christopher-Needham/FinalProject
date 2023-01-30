/**
 * 
 */
package com.promineotech.batour.entity;

/**
 * @author 17015
 *
 */
public class StateModel {
  
  private String username;
  private String state_name;
  
  
  public StateModel (String username, String state_name) {
    setUsername(username);
    setState_name(state_name);
    
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
  /**
   * @return the state_name
   */
  public String getState_name() {
    return state_name;
  }
  /**
   * @param state_name the state_name to set
   */
  public void setState_name(String state_name) {
    this.state_name = state_name;
  }


}
