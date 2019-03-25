package com.v2gdemo.googlemap.config;

import com.v2gdemo.googlemap.places.FindPlaceImpl;
import com.v2gdemo.googlemap.places.FindPlaceObject;
import com.v2gdemo.googlemap.places.FindRouteImpl;
import com.v2gdemo.googlemap.places.FindRouteObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GoogleConfig {
    @Bean
    public FindRouteObject findRouteObject(@Value("${google.secret.key}") String key){
        FindRouteImpl findRoute = new FindRouteImpl();
        findRoute.setKey(key);
        return findRoute;

    }
    @Bean
    public FindPlaceObject findPlaceObject(@Value("${google.secret.key}") String key) throws Exception{
        FindPlaceImpl findPlace = new FindPlaceImpl();
        System.out.println(key);
        findPlace.setKey(key);
        return findPlace;
    }
}
