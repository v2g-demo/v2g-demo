package com.v2gdemo.places;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.BufferedReader;

public class FindPlaceImpl implements FindPlaceObject {
   private URIBuilder builder;
    private HttpGet getReq;
    private HttpClient client;
    private BufferedReader reader;
    private HttpResponse httpResponse;
    private StringBuilder builders;
    private String s;
    private ObjectMapper mapper;
    private JsonNode node;
    private String key;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }


    public JsonNode sendRequest(PlaceAutocompleteRequest request) throws Exception {
         builder = new URIBuilder("https://maps.googleapis.com/maps/api/place/queryautocomplete/json");
        builder.addParameter("key", key);
        builder.addParameter("input", request.getInput());
        builder.addParameter("location", request.getLoc());
        builder.addParameter("radius", request.getRad());


        getReq= new HttpGet(builder.build());

        client = HttpClientBuilder.create().build();
        httpResponse = client.execute(getReq);

        String prediction = EntityUtils.toString(httpResponse.getEntity());
        mapper = new ObjectMapper();
        JsonNode nodes =  mapper.readTree(prediction);

        return nodes;
    }

    @Override
    public JsonNode getChargeStations( String radius, String location) throws Exception {
        return this.sendRequest(new PlaceAutocompleteRequest("car charger",radius,location,true));
    }



    private class PlaceAutocompleteRequest {
        private String input;
        private String rad;
        private String loc;
        private boolean strictBounds;

        public String getInput() {
            return input;
        }

        public void setInput(String input) {
            this.input = input;
        }

        public String getRad() {
            return rad;
        }

        public void setRad(String rad) {
            this.rad = rad;
        }

        public String getLoc() {
            return loc;
        }

        public void setLoc(String loc) {
            this.loc = loc;
        }

        public boolean isStrictBounds() {
            return strictBounds;
        }

        public void setStrictBounds(boolean strictBounds) {
            this.strictBounds = strictBounds;
        }

        public PlaceAutocompleteRequest(String input, String rad, String loc, boolean strictBounds) {
            this.input = input;
            this.rad = rad;
            this.loc = loc;
            this.strictBounds = strictBounds;
        }
    }


    public JsonNode getDetails(String placeID) throws Exception{
        URIBuilder builder = new URIBuilder("https://maps.googleapis.com/maps/api/place/details/json");
        builder.addParameter("placeid",placeID);
        builder.addParameter("key",key);

        HttpClient client = HttpClientBuilder.create().build();
        HttpResponse response = client.execute(new HttpGet(builder.build()));


        String details  = EntityUtils.toString(response.getEntity());

        ObjectMapper mapper = new ObjectMapper();
        return mapper.readTree(details);


    }
}
