/**
 * 
 */
package com.promineotech.batour.controllers;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.batour.entity.PlayerGameModel;
import com.promineotech.batour.entity.StateModel;
import com.promineotech.batour.service.BatourService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * @author 17015
 *
 */
@Tag(name = "PlayerGames")
@RestController
public class PlayerGameController {
  
  private BatourService service;
  
  public PlayerGameController(BatourService service) {
    this.service = service;
  }
  @Operation(summary = "gets all players with games")
  @GetMapping(value = "/player_games")
  
  public List<PlayerGameModel> all(){
    List<PlayerGameModel> pg = service.getPlayerGames();
    return pg;
    
  }

}
