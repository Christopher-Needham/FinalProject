/**
 * 
 */
package com.promineotech.batour.controllers;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import com.promineotech.batour.entity.GameModel;
import com.promineotech.batour.service.BatourService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * @author 17015
 *
 */
@Tag(name = "Games")
@RestController

public class GameController {
  
  private BatourService service;
  
  public GameController(BatourService service) {
    this.service = service;
  }
  
  @Operation(summary = "Gets all the available games")
  @GetMapping(value = "/games")
  public List<GameModel> all(){
    List<GameModel> games = service.getGames();
    return games;
    
  }
  @Operation(summary = "Gets a game by game Anotation")
  @GetMapping(value = "/games/{gameAnotation}")
  public GameModel get(@PathVariable String gameAnotation) {
    if ((gameAnotation != null) && (! gameAnotation.isEmpty())){
      GameModel game = service.getGames(gameAnotation);
      if(game != null) {
        return game;
      }
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, 
                                        String.format("game (%s) not found", gameAnotation));
      
      // call service layer
    }
    throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "game anotation not provided.");
    
    
    
  }

}
