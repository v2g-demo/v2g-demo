package com.v2gdemo.backend.restcontroller;

import com.v2gdemo.backend.entity.Character;
import com.v2gdemo.backend.restcontroller.exception.ServerException;
import com.v2gdemo.backend.service.ApiService;
import com.v2gdemo.backend.service.CreateCharactersService;
import com.v2gdemo.backend.service.MoveVehicleService;
import com.v2gdemo.places.FindRouteObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiController {
  @Autowired
  private ApiService apiService;
@Autowired
private MoveVehicleService moveVehicle;
  @Autowired
  private FindRouteObject findRoute;
  @Autowired
  private CreateCharactersService createCharactersService;
   @GetMapping("/buildroute")
  public String buildRoute(@RequestParam(name = "from") long from,@RequestParam("to") long to) throws ServerException{
return apiService.buildRoute(from,to);
   }

   @GetMapping("/moveVehicle")
  public String moveVehicle(@RequestParam(name = "vehicleID") long carId,@RequestParam(name = "objectID") long
                            objId){
          return moveVehicle.move(carId, objId);

   }
}
