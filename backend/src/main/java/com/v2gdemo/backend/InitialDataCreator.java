package com.v2gdemo.backend;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.v2gdemo.backend.dao.UserDao;
import com.v2gdemo.backend.entity.*;
import com.v2gdemo.backend.entity.Character;
import com.v2gdemo.backend.entity.Object;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.ClassPathResource;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

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
    @Autowired
  public InitialDataCreator(CharacterRepository characterRepository, UserDao userDao, ObjectRepository objectRepository, MapRepository mapRepository, RespawnPointRepository respawnPointRepository){
    this.charRepository = characterRepository;
    this.userDao = userDao;
    this.objectRepository =  objectRepository;
    this.mapRepository = mapRepository;
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
        user = userDao.save(user);

        Character character = new Character();
        character.setUser(user);
        character.setMap(map);
        character.setName("Allego");
        character.setRole(Character.Role.ORGANIZATION);
        character = charRepository.save(character);

      for (int i =0; i<3; i++) {
        Object object = new Object();
        int multiplicator  = i /100;
        object.setFormattedAddress("Alexanderpl. 5, 10178 Berlin");
        object.setLocation(new Object.Location(52.522703+multiplicator, 13.413916+multiplicator));
        object.setName("Allego num_"+i);
        if (i == 2) object.setPlaceId("ChIJxSFOWTx_bIcRyzrZOTJ7YUM"); else object.setPlaceId("ChIJlQn4WGa5dUcRDT6kUOs8dtM");
        object.setReference(null);
        object.setRotationAngle(0);
        object.setType(Object.Type.CHARGER);
        object.setMap(map);
        object.setOwner(character);
        objectRepository.save(object);
      }

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
