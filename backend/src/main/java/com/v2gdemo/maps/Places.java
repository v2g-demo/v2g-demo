package com.v2gdemo.maps;

import com.google.maps.DirectionsApi;
import com.google.maps.FindPlaceFromTextRequest;
import com.google.maps.GeoApiContext;
import com.google.maps.PlacesApi;
import com.google.maps.model.DirectionsResult;
import com.google.maps.model.FindPlaceFromText;
import com.google.maps.model.LatLng;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class Places {
    //private String key;
    private GeoApiContext context;
    public Places(@Value("${google.secret.key}") String key) {
         context = new GeoApiContext.Builder()
                .apiKey(key)
                .build();
    }

    public String GetChargers(LatLng southWest, LatLng northEast) {
        FindPlaceFromTextRequest req = PlacesApi.findPlaceFromText(context, "car charger",
                FindPlaceFromTextRequest.InputType.TEXT_QUERY)
                .fields(
                        FindPlaceFromTextRequest.FieldMask.PHOTOS,
                        FindPlaceFromTextRequest.FieldMask.FORMATTED_ADDRESS,
                        FindPlaceFromTextRequest.FieldMask.ID,
                        FindPlaceFromTextRequest.FieldMask.NAME,
                        //FindPlaceFromTextRequest.FieldMask.RATING,
                        //FindPlaceFromTextRequest.FieldMask.OPENING_HOURS,
                        FindPlaceFromTextRequest.FieldMask.GEOMETRY)
                .locationBias(new FindPlaceFromTextRequest.LocationBiasRectangular(southWest, northEast));
        try {
            FindPlaceFromText results = req.await();
            return Arrays.toString(results.candidates);
            // Handle successful request.
        } catch (Exception e) {
            // Handle error
            System.out.println(e.toString());
            return null;
        }
    }

    public void GetRoute() {
        DirectionsResult res = DirectionsApi.getDirections(context, "улица свободы", "химки").awaitIgnoreError();
        System.out.println(res.toString());

    }

}
