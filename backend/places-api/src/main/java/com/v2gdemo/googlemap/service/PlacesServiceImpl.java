package com.v2gdemo.googlemap.service;

import com.v2gdemo.googlemap.database.ChargerDao;

import com.v2gdemo.googlemap.entity.ChargeStation;
import com.v2gdemo.googlemap.places.FindPlaceObject;
import com.v2gdemo.googlemap.places.FindRouteObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlacesServiceImpl implements PlacesService {
    @Autowired
    private ChargerDao dao;
    @Autowired
    private FindPlaceObject findPlaceObject;
    @Autowired
    private FindRouteObject findRouteObject;
    @Override
    public boolean save(String id, String location) {
        dao.save(id, location);
        return true;
    }

    @Override
    public String findRouteBetween(String from, String to) {
        return findRouteObject.findRouteBetween(from,to);
    }

    @Override
    public String getChargeStations(String id,String radius)  {
        try {
            return findPlaceObject.getChargeStations(radius, get(id).getLocation()).get("predictions").toString();
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public ChargeStation get(String id) {
        return new ChargeStation(id,dao.get(id),"desc");
    }
}
