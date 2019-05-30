package com.v2gdemo.backend;


import com.google.maps.model.LatLng;
import com.v2gdemo.maps.Places;
import com.v2gdemo.places.FindPlaceImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class InitialDataCreatorTest {

  @Test
  public void createRespawnPoints() throws Exception{

    FindPlaceImpl places = new FindPlaceImpl();
    places.setKey("key");
    System.out.println(places.getChargeStations("55.751244,37.618423","5000"));

  }
}
