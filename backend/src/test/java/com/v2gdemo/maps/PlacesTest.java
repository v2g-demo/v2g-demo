package com.v2gdemo.maps;

import com.google.maps.model.LatLng;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import static org.junit.Assert.*;

public class PlacesTest {

String key = "key";
    @Test
    public void getChargers() {
        Places p = new Places( key);
      System.out.println(p.GetChargers(new LatLng(33,21),new LatLng(33,21)));

    }
}
