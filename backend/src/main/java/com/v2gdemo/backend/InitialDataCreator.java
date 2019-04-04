package com.v2gdemo.backend;

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
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import java.util.Collections;


@RequiredArgsConstructor
@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class InitialDataCreator implements ApplicationListener<ApplicationReadyEvent> {
    @NonNull
    private  CharacterRepository charRepository;
 private UserDao userDao;
 private ObjectRepository objectRepository;


 private MapRepository mapRepository;
    @Autowired
  public InitialDataCreator(CharacterRepository characterRepository, UserDao userDao, ObjectRepository objectRepository, MapRepository mapRepository){
    this.charRepository = characterRepository;
    this.userDao = userDao;
    this.objectRepository =  objectRepository;
    this.mapRepository = mapRepository;

  }
    public void onApplicationEvent(ApplicationReadyEvent event) {
        System.out.println("42");
       if (userDao.count() > 0) {
            return;
     }




       Map map = new Map();
       map.setCenter(new Map.Location(52.520008,13.404954));
       map.setZoom(5);
       map.setName("Berlin");
      mapRepository.save(map);

User user = new User();
user.setId("someid");
user.setName("Somename");
user.setLogin("log");
user.setPassword("passwords"
);
userDao.save(user);


      for (int i =0;i<3;i++) {
        Object object = new Object();
        int multiplicator  = i /100;
        object.setFormattedAddress("Alexanderpl. 5, 10178 Berlin");
        object.setLocation(new Object.Location(52.522703+multiplicator, 13.413916+multiplicator));
        object.setName("Allego num"+i);
        if (i == 2) object.setPlaceId("ChIJxSFOWTx_bIcRyzrZOTJ7YUM"); else object.setPlaceId("ChIJlQn4WGa5dUcRDT6kUOs8dtM");
        object.setReference(null);
        object.setRotationAngle(0);
        object.setType(Object.Type.CHARGER);
        object.setMap(map);
        objectRepository.save(object);
      }
      Object object = new Object();
      object.setMap(map);
      object.setType(Object.Type.VEHICLE);
      object.setName("my car");
      object.setPlaceId("places");


      Character character = new Character();
      character.setUser(user);
      character.setMap(map);
      character.setName("Somename");
      object.setOwner(character);

      objectRepository.save(object);

    }
}
