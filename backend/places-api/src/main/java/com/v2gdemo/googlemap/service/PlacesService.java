package com.v2gdemo.googlemap.service;


import com.v2gdemo.googlemap.entity.ChargeStation;

public interface PlacesService {
    boolean save(String id,String location);
    ChargeStation get(String id);
    String getChargeStations(String id,String radius);
    String findRouteBetween(String from,String to);
}
