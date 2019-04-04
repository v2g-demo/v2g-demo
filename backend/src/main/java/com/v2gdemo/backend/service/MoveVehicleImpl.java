package com.v2gdemo.backend.service;

import com.v2gdemo.backend.entity.Object;
import com.v2gdemo.backend.entity.ObjectRepository;
import com.v2gdemo.backend.restcontroller.exception.ServerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MoveVehicleImpl implements MoveVehicleService {
  @Autowired
  private ObjectRepository objectRepository;
  @Override
  public String move(long carId, long objId) {
    Object car = objectRepository.findById(carId).orElseThrow(()->{
      throw  new ServerException("Wrong car id!");
    });
    Object object = objectRepository.findById(objId).orElseThrow(()->{
      throw  new ServerException("Wrong object id!");
    });
   if (!car.getType().equals(Object.Type.VEHICLE)) throw new ServerException("Car id doesnt relate to vehicle!");
    car.setLocation(object.getLocation());
    objectRepository.save(car);
    return "Successful changed car location!";
  }
}
