package com.v2gdemo.backend.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.v2gdemo.backend.entity.Object;
import com.v2gdemo.backend.entity.ObjectRepository;
import com.v2gdemo.backend.restcontroller.exception.ServerException;
import com.v2gdemo.places.FindPlaceObject;
import com.v2gdemo.places.FindRouteObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApiService {
@Autowired
private ObjectRepository objectRepository;
@Autowired
private FindPlaceObject findPlaceObject;
@Autowired
private FindRouteObject findRouteObject;
  public String buildRoute(long from,long to){
    final String fromObj = "place_id:"+ objectRepository.findById(from).orElseThrow(() -> {
      throw new ServerException("Wrong id! (from): " + from);
    }).getPlaceId();
    final String toObj ="place_id:"+ objectRepository.findById(to).orElseThrow(() -> {
      throw new ServerException("Wrong id! (to): " + to);
    }).getPlaceId();
return findRouteObject.findRouteBetween(fromObj,toObj);
  }


  public JsonNode getChargers(String radius,long objId) throws Exception
  {
    Object.Location location = objectRepository.findById(objId).orElseThrow(()->{
      throw new ServerException("Wrong objectId!:"+ objId);
    }).getLocation();
    return findPlaceObject.getChargeStations(radius,location.getLatitude()+","+location.getLongitude());
  }


}
