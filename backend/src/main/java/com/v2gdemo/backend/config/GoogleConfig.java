package com.v2gdemo.backend.config;

import com.v2gdemo.places.FindPlaceImpl;
import com.v2gdemo.places.FindPlaceObject;
import com.v2gdemo.places.FindRouteImpl;
import com.v2gdemo.places.FindRouteObject;
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
        findPlace.setKey(key);
        return findPlace;
    }
}
