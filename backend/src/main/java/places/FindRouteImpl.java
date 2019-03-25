package com.v2gdemo.googlemap.places;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

public class FindRouteImpl implements FindRouteObject {
    private String key;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public String findRouteBetween(String from, String to) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Accept","application/json");

        String url = "https://maps.googleapis.com/maps/api/directions/json";

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("origin", from).queryParam("destination",to).queryParam("key",key);

        org.springframework.http.HttpEntity<?> httpEntity = new org.springframework.http.HttpEntity<>(httpHeaders);

        HttpEntity<String> response =restTemplate.exchange(builder.toUriString(), HttpMethod.GET,httpEntity,String.class);

        System.out.println(response.getBody());

        return response.getBody();
    }
}
