package com.v2gdemo.backend;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.maps.model.LatLng;
import com.v2gdemo.backend.dao.UserDao;
import com.v2gdemo.backend.entity.*;
import com.v2gdemo.backend.entity.Character;
import com.v2gdemo.backend.entity.Object;
import com.v2gdemo.maps.Places;
import com.v2gdemo.places.FindPlaceObject;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.ClassPathResource;
import org.springframework.lang.NonNull;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;


@RequiredArgsConstructor
@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class InitialDataCreator implements ApplicationListener<ApplicationReadyEvent> {
    @NonNull
    private  CharacterRepository charRepository;
    private UserDao userDao;
    private ObjectRepository objectRepository;
    private RespawnPointRepository respawnPointRepository;
    private MapRepository mapRepository;
    private PasswordEncoder passwordEncoder;
    @Autowired
    private FindPlaceObject findPlaceObject;
    @Autowired
  public InitialDataCreator(CharacterRepository characterRepository, UserDao userDao, PasswordEncoder passwordEncoder, ObjectRepository objectRepository, MapRepository mapRepository, RespawnPointRepository respawnPointRepository){
    this.charRepository = characterRepository;
    this.userDao = userDao;
    this.objectRepository =  objectRepository;
    this.mapRepository = mapRepository;
    this.passwordEncoder = passwordEncoder;
    this.respawnPointRepository = respawnPointRepository;


  }
    public void onApplicationEvent(ApplicationReadyEvent event) {

        // TODO: fix this check does not work
        if (userDao.count() > 0) {
            return;
        }

       Map map = new Map();
       map.setCenter(new Map.Location(52.520008,13.404954));
       map.setZoom(5);
       map.setName("Berlin");
       map = mapRepository.save(map);

        User user = new User();
        user.setName("system");
        user.setPassword(passwordEncoder.encode("pass"));
        user.setLogin("login");
        user.setRole(User.Role.PLAYER);
        user = userDao.save(user);

        Character character = new Character();
        character.setUser(user);
        character.setMap(map);
        character.setName("Allego");
        character.setRole(Character.Role.ORGANIZATION);
        charRepository.save(character);

        try {
          JsonNode chargeStations = findPlaceObject.getChargeStations("50", "57.751244,37.618423");
          for (JsonNode js: chargeStations) {
            for (JsonNode jsonNode: js) {
              Object object = new Object();
              object.setName(jsonNode.get("description").asText());
              object.setReference(jsonNode.get("reference").asText());
              object.setLocation(new Object.Location(52.520008, 13.404954));
              object.setPlaceId(jsonNode.get("place_id").asText());
              object.setType(Object.Type.CHARGER);
              object.setRotationAngle(0);
              object.setOwner(character);
              Wallet wallet = new Wallet();
              wallet.setObject(object);
              object.setWallet(wallet);
              objectRepository.save(object);

            }

          }
        } catch (Exception ex){ex.printStackTrace();}




    try {
      createRespawnPoints(map);
    } catch (Exception ex){ex.printStackTrace();}

    System.out.println("===== Initial data loaded.");
    }

    public void createRespawnPoints(Map map) throws Exception{
      ObjectMapper mapper =new ObjectMapper();
      List<RespawnPoint> respawnPoints = mapper.readValue(new ClassPathResource("static/respawn-points.json").getFile(), mapper.getTypeFactory().constructCollectionType(List.class,RespawnPoint.class));
      respawnPoints.forEach((respawnPoint)->{
        respawnPoint.setMap(map);
      });
      this.respawnPointRepository.saveAll(respawnPoints);
      System.out.println(respawnPoints.toString());
    }
}
