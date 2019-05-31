package com.v2gdemo.backend.restcontroller;

import com.v2gdemo.backend.dao.UserDao;
import com.v2gdemo.backend.entity.Character;
import com.v2gdemo.backend.entity.CharacterRepository;
import com.v2gdemo.backend.entity.Transaction;
import com.v2gdemo.backend.restcontroller.exception.ServerException;
import com.v2gdemo.backend.service.ApiService;
import com.v2gdemo.backend.service.BillingService;
import com.v2gdemo.backend.service.CreateCharactersService;
import com.v2gdemo.backend.service.MoveVehicleService;
import com.v2gdemo.places.FindRouteObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("api")
public class ApiController {
  @Autowired
  private BillingService billingService;
  @Autowired
  private ApiService apiService;
@Autowired
private MoveVehicleService moveVehicle;
  @Autowired
  private FindRouteObject findRoute;
  @Autowired
  private CharacterRepository characterRepository;
  @Autowired
  private UserDao userDao;
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

    @GetMapping("/createCharacter")
    public Character createCharacters(@RequestParam("userId") Long userId, @RequestParam("mapId") long mapId) {
        return createCharactersService.createCharacters(userId, mapId);
    }

   @PostMapping("/makeTransaction")
  public Transaction makeTransaction(@RequestParam("fromAddress") String fromAddress,@RequestParam("toAddress") String toAddress,@RequestParam("value") long value){

    return billingService.makeTransaction(fromAddress,toAddress,value);

   }
}
