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

    public String makeRequest() throws IOException {

        OkHttpClient client = new OkHttpClient();

        // Building the URL to get request
        Request request = new Request.Builder()
                .url("https://api.predicthq.com/v1/events?within=5km@48.858353,2.294464")
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
            newEvent.add("location_of_event", oldEventObject.get("location"));
            newEvent.add("distance_from_location", new JsonPrimitive(1));
            newEvent.add("labels", oldEventObject.get("labels"));

            newEvents.add(newEvent);
        }

        newJsonObject.add("events", newEvents);

        return newJsonObject.toString();
    }

}
