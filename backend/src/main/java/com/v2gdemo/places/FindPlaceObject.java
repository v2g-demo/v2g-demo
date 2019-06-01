package com.v2gdemo.places;

import com.fasterxml.jackson.databind.JsonNode;

public interface FindPlaceObject {

     JsonNode getChargeStations(String radius,String location) throws Exception;
     JsonNode getChargeStations(String radius,String location,String nextPageToken) throws Exception;
     JsonNode getDetails(String placeId) throws Exception;


}
