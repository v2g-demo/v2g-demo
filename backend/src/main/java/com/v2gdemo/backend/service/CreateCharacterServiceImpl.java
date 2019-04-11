package com.v2gdemo.backend.service;

import com.v2gdemo.backend.dao.UserDao;
import com.v2gdemo.backend.entity.*;
import com.v2gdemo.backend.entity.Character;
import com.v2gdemo.backend.entity.Object;
import com.v2gdemo.backend.restcontroller.exception.ServerException;
import io.lettuce.core.internal.LettuceLists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class CreateCharacterServiceImpl implements CreateCharactersService {

  @Autowired
  private UserDao userDao;
  @Autowired
  private RespawnPointRepository respawnPointRepository;
  @Autowired
  private CharacterRepository characterRepository;
  @Autowired
  private MapRepository mapRepository;
  @Autowired
  private ObjectRepository objectRepository;
  @Override
  public Character createCharacters(String userId, long mapId) {
    User user = userDao.findById(userId).orElseThrow(()->{
      throw new ServerException("Wrong user id!");
    });
    com.v2gdemo.backend.entity.Character character = new com.v2gdemo.backend.entity.Character();
    character.setName(UUID.randomUUID().toString());
    character.setMap(mapRepository.findById(mapId).orElseThrow(()->{
      throw new ServerException("Wrong map id!");
    }));
    Object car = new Object();
    List<RespawnPoint> respawnPoints = LettuceLists.newList(respawnPointRepository.findAll());
    RespawnPoint respawnPoint = respawnPoints.get(ThreadLocalRandom.current().nextInt(respawnPoints.size()));
    car.setLocation(new Object.Location(respawnPoint.getLatitude(),respawnPoint.getLongitude()));
    car.setType(Object.Type.VEHICLE);
    Object home = new Object();
    home.setLocation(new Object.Location(respawnPoint.getLatitude(),respawnPoint.getLongitude()));
    home.setType(Object.Type.HOUSE);
    character.setUser(user);
    character.getObjects().addAll(Stream.of(car,home).collect(Collectors.toList()));
    character.setRole(Character.Role.PERSON);
    characterRepository.save(character);
    return character;
  }
}