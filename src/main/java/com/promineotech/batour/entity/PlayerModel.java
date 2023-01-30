/**
 * 
 */
package com.promineotech.batour.entity;



/**
 * @author 17015
 *
 */

public class PlayerModel {
  
  
  private String username;
  private Integer age;
  private String date_birth;
  
  public PlayerModel(String username, Integer age, String date_birth) {
    setDate_birth(date_birth);
    setUsername(username);
    setAge(age);
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
   * @return the age
   */
  public Integer getAge() {
    return age;
  }
  /**
   * @param age the age to set
   */
  public void setAge(Integer age) {
    this.age = age;
  }
  /**
   * @return the date_birth
   */
  public String getDate_birth() {
    return date_birth;
  }
  /**
   * @param date_birth the date_birth to set
   */
  public void setDate_birth(String date_birth) {
    this.date_birth = date_birth;
  }
  
  public boolean isValid() {
    
    return getUsername() != null && (! getUsername().isEmpty());
  }


}
