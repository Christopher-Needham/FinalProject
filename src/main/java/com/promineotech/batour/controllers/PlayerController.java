/**
 * 
 */
package com.promineotech.batour.controllers;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import com.promineotech.batour.entity.PlayerInputModel;
import com.promineotech.batour.entity.PlayerModel;
import com.promineotech.batour.service.BatourService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * @author 17015
 *
 */

@Tag(name = "Players")
@OpenAPIDefinition(info = @Info(title = "Players in the database..."))
@RestController
public class PlayerController {
  

    private BatourService service;
    
    public PlayerController(BatourService service) {
      this.service = service;
    }

      @Operation(summary = "Gets all available players")
      @GetMapping(value = "/player")
      
      public List<PlayerModel> all(){
        List<PlayerModel> player = service.getPlayers();
        return player;
      }  
    
    
    
    
    @Operation(summary = "Gets player by username")
    @GetMapping(value = "/player/{username}")
    public PlayerModel get(@PathVariable String username){
      if ((username != null) && (! username.isEmpty())){
        PlayerModel player = service.getPlayers(username);
        if(player != null) {
          return player;
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, 
                                          String.format("player (%s) not found", username));
        
        // call service layer
      }
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "player username not provided.");
      
      
      
    }
    @Operation(summary = "Creates a new player")
    @PostMapping(value = "/player")
    public PlayerModel create(@RequestBody PlayerInputModel input) {
      if ((input != null) && (input.isValid())) {
        PlayerModel player = service.createPlayer(input);
        if (player != null) {
          return player;
        }
        throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "An unhandled exception occured, player not created");
        
      }
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "player username not provided.");
      
    }
    
    @Operation(summary = "Deletes player from database")
    @DeleteMapping(value = "/player/{username}")
    public PlayerModel delete(@PathVariable String username) {
      if ((username != null) && (! username.isEmpty())) {
        PlayerModel player = service.deletePlayer(username);
        if (player != null) {
          return player;
        //happy path
        }
        throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "An unhandled exception occured, player cannot be deleted");
      }
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, String.format("Invalid Player. Value: %s", username));
    }
    
    @Operation(summary = "Updates existing player")
    @PutMapping(value = "/player/{username}")
    public PlayerModel update(@PathVariable String username, @RequestBody PlayerModel input) {
      if((input != null) && (input.isValid())) {
          PlayerModel player = service.updatePlayer(username, input);
          
          if(player != null) {
            return player;
            
          }
          throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR, "An unhandled exception occured, player cannot be updated");       
      }
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, String.format("Invalid Player. (player controller) Value: %s", input.getUsername()));
    }

}
