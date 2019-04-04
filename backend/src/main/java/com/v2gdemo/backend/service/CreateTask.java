package com.v2gdemo.backend.service;

import com.v2gdemo.backend.dao.UserDao;
import com.v2gdemo.backend.entity.*;
import com.v2gdemo.backend.entity.Character;
import com.v2gdemo.backend.entity.Object;
import io.lettuce.core.internal.LettuceLists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Service
public class CreateTask {
  @Autowired
  private CharacterRepository characterRepository;
  @Autowired
  private ObjectRepository objectRepository;
@Autowired
private TaskRepository taskRepository;
  private static final long DELAY = 10000;


  @Scheduled(fixedDelay = DELAY)
  public void createRandomTask(){

    List<Object> objects = LettuceLists.newList(objectRepository.findAll());

    List<Character> characters = LettuceLists.newList(characterRepository.findAll());
    for (Character character :characters ){
       Object car =  character.getObjects().stream().filter( (o) ->{
         return o.getType().equals(Object.Type.VEHICLE);
        }).findAny().get();
      List<Object> manfctr = objects.stream().filter((ob)->{
        return !ob.getType().equals(Object.Type.VEHICLE);
      }).filter((ob)->{
        return ob.getMap().getId().equals(car.getMap().getId());
      }).collect(Collectors.toList());
       int rand = new Random().nextInt(manfctr.size());
      Object randomBuilding = manfctr.get(rand);
      Task task = new Task();
      task.setCar(car);
      task.setTo(randomBuilding);
       taskRepository.save(task);
      }

  }
}
