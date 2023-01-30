/**
 * 
 */
package com.promineotech.batour.controllers;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
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
@Tag(name = "States")
@RestController
public class StateController {
  
  private BatourService service;
  
  public StateController(BatourService service) {
    this.service = service;
  }
  @Operation(summary = "gets all players with states")
  @GetMapping(value = "/states")
  
  public List<StateModel> all(){
    List<StateModel> state = service.getStates();
    return state;
    
  }

}
