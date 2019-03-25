package com.v2gdemo.googlemap.places;

import com.fasterxml.jackson.databind.JsonNode;

public interface FindPlaceObject {

     JsonNode getChargeStations(String radius,String location) throws Exception;



}
