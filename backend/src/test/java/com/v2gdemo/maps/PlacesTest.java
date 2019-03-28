package com.v2gdemo.maps;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import static org.junit.Assert.*;

public class PlacesTest {

    @Value("${google.secret.key}") String key;
    @Test
    public void getChargers() {
        Places p = new Places( key);
        //p.GetChargers();
        p.GetRoute();
    }
}