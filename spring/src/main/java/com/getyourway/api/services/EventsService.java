package com.getyourway.api.services;

import com.google.gson.*;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.ResponseBody;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class EventsService {

    @Value("${predicthq.api-key}")
    private String PREDICT_HQ_API_KEY;

    public String makeRequest(double latitude, double longitude) throws IOException {

        OkHttpClient client = new OkHttpClient();

        // Building the URL to get request
        Request request = new Request.Builder()
                .url(String.format("https://api.predicthq.com/v1/events?within=5km@%f,%f", latitude, longitude))
                .get()
                .addHeader("Authorization", "Bearer " + PREDICT_HQ_API_KEY)
                .build();

        ResponseBody responseBody = client.newCall(request).execute().body();
        String responseBodyString = null != responseBody ? responseBody.string() : "{}";

        JsonElement oldJsonElement = new Gson().fromJson(responseBodyString, JsonElement.class);
        JsonObject oldJsonObject = oldJsonElement.getAsJsonObject();

        JsonObject newJsonObject = new JsonObject();

        JsonArray oldEvents = oldJsonObject.get("results").getAsJsonArray();

        JsonArray newEvents = new JsonArray();
        for (JsonElement oldEvent: oldEvents) {
            JsonObject oldEventObject = oldEvent.getAsJsonObject();

            JsonObject newEvent = new JsonObject();

            newEvent.add("title", oldEventObject.get("title"));
            newEvent.add("description", oldEventObject.get("description"));
            newEvent.add("start_date", oldEventObject.get("start"));
            newEvent.add("end_date", oldEventObject.get("end"));

            JsonElement locationElement = oldEventObject.get("location");
            newEvent.add("location_of_event", locationElement);

            JsonArray locationArray = locationElement.getAsJsonArray();
            double eventLatitude = locationArray.get(1).getAsDouble();
            double eventLongitude = locationArray.get(0).getAsDouble();

            // calculate distance
            String distance = distance(latitude, longitude, eventLatitude, eventLongitude) + "km";
            newEvent.add("distance_from_location", new JsonPrimitive(distance));
            newEvent.add("labels", oldEventObject.get("labels"));

            newEvents.add(newEvent);
        }

        newJsonObject.add("events", newEvents);

        return newJsonObject.toString();
    }

    private double distance(double lat1, double lon1, double lat2, double lon2) {
        double theta = lon1 - lon2;
        double dist = Math.sin(deg2rad(lat1)) * Math.sin(deg2rad(lat2))
                + Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) * Math.cos(deg2rad(theta));
        dist = Math.acos(dist);
        dist = rad2deg(dist);
        dist *= 60 * 1.1515;
        dist *= 1.609344;
        return (dist);
    }

    private double deg2rad(double deg) {
        return (deg * Math.PI / 180.0);
    }

    private double rad2deg(double rad) {
        return (rad * 180.0 / Math.PI);
    }

}
