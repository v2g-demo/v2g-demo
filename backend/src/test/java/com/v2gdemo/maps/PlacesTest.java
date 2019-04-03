package com.v2gdemo.maps;

import com.google.maps.model.LatLng;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import static org.junit.Assert.*;

public class PlacesTest {

String key = "AIzaSyAWUnoy9yDb5m2wgQ0Pxcx58Z6fdMIDEOc";
    @Test
    public void getChargers() {
        Places p = new Places( key);
      System.out.println(p.GetChargers(new LatLng(39,16.576124),new LatLng(49,13)));

    }
}
