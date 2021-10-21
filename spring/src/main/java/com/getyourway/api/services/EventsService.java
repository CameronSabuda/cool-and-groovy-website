package com.getyourway.api.services;

import com.google.gson.*;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.ResponseBody;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
public class EventsService {

    @Value("${predicthq.api-key}")
    private String PREDICT_HQ_API_KEY;

    public String getEventsWithin5km(double latitude, double longitude) throws IOException {

//        JsonObject unfilteredJsonObject = fetchEventsList(latitude, longitude);
//
//        JsonObject filteredJsonObject = filterExternalJsonObject(unfilteredJsonObject, latitude, longitude);
//
//        return filteredJsonObject.toString();

        return "{\"events\":[{\"title\":\"NonLeagueDivOne-NorthernEast-OssettUnitedvsPickeringTown\",\"description\":\"\",\"category\":\"sports\",\"start_date\":\"06-11-2115:00:00\",\"end_date\":\"06-11-2115:00:00\",\"location_of_event\":[-1.577547,53.681522],\"distance_from_location\":\"0.101km\",\"labels\":[\"soccer\",\"sport\"]},{\"title\":\"AlexanderO\\'Neal\",\"description\":\"\",\"category\":\"concerts\",\"start_date\":\"30-10-2118:00:00\",\"end_date\":\"30-10-2118:00:00\",\"location_of_event\":[-1.6272782,53.7115572],\"distance_from_location\":\"4.649km\",\"labels\":[\"concert\",\"music\"]},{\"title\":\"Wakefield-AutumnHalfTermHolidays\",\"description\":\"\",\"category\":\"school-holidays\",\"start_date\":\"23-10-2100:00:00\",\"end_date\":\"31-10-2123:59:59\",\"location_of_event\":[-1.49895,53.68085],\"distance_from_location\":\"5.265km\",\"labels\":[\"holiday\",\"school\"]}]}{\"events\":[{\"title\":\"NonLeagueDivOne-NorthernEast-OssettUnitedvsPickeringTown\",\"description\":\"\",\"category\":\"sports\",\"start_date\":\"06-11-2115:00:00\",\"end_date\":\"06-11-2115:00:00\",\"location_of_event\":[-1.577547,53.681522],\"distance_from_location\":\"0.101km\",\"labels\":[\"soccer\",\"sport\"]},{\"title\":\"AlexanderO\\'Neal\",\"description\":\"\",\"category\":\"concerts\",\"start_date\":\"30-10-2118:00:00\",\"end_date\":\"30-10-2118:00:00\",\"location_of_event\":[-1.6272782,53.7115572],\"distance_from_location\":\"4.649km\",\"labels\":[\"concert\",\"music\"]},{\"title\":\"Wakefield-AutumnHalfTermHolidays\",\"description\":\"\",\"category\":\"school-holidays\",\"start_date\":\"23-10-2100:00:00\",\"end_date\":\"31-10-2123:59:59\",\"location_of_event\":[-1.49895,53.68085],\"distance_from_location\":\"5.265km\",\"labels\":[\"holiday\",\"school\"]}]}";}

    private JsonObject fetchEventsList(double latitude, double longitude) throws IOException {

        OkHttpClient client = new OkHttpClient();

        // Building the URL to get request
        Request request = new Request.Builder()
                .url(String.format("https://api.predicthq.com/v1/events?within=5km@%f,%f", latitude, longitude))
                .get()
                .addHeader("Authorization", "Bearer " + PREDICT_HQ_API_KEY)
                .build();

        ResponseBody responseBody = client.newCall(request).execute().body();
        String responseBodyString = null != responseBody ? responseBody.string() : "{}";

        JsonElement unfilteredJsonElement = new Gson().fromJson(responseBodyString, JsonElement.class);
        return unfilteredJsonElement.getAsJsonObject();
    }

    private JsonObject filterExternalJsonObject(JsonObject unfilteredJsonObject, double latitude, double longitude) {
        JsonArray unfilteredEvents = unfilteredJsonObject.get("results").getAsJsonArray();

        JsonArray filteredEvents = new JsonArray();
        for (JsonElement unfilteredEvent: unfilteredEvents) {
            JsonObject unfilteredEventObject = unfilteredEvent.getAsJsonObject();

            if (!unfilteredEventObject.get("category").getAsString().matches("observances|daylight-savings")) {
                JsonObject filteredEvent = new JsonObject();

                filteredEvent.add("title", unfilteredEventObject.get("title"));
                filteredEvent.add("description", unfilteredEventObject.get("description"));
                filteredEvent.add("category", unfilteredEventObject.get("category"));
                filteredEvent.add("start_date", new JsonPrimitive(formatDate(unfilteredEventObject.get("start").getAsString())));
                filteredEvent.add("end_date", new JsonPrimitive(formatDate(unfilteredEventObject.get("end").getAsString())));

                JsonElement locationElement = unfilteredEventObject.get("location");
                filteredEvent.add("location_of_event", locationElement);

                JsonArray locationArray = locationElement.getAsJsonArray();
                double eventLatitude = locationArray.get(1).getAsDouble();
                double eventLongitude = locationArray.get(0).getAsDouble();

                // calculate distance
                String distance = String.format("%.3fkm", distance(latitude, longitude, eventLatitude, eventLongitude));
                filteredEvent.add("distance_from_location", new JsonPrimitive(distance));
                filteredEvent.add("labels", unfilteredEventObject.get("labels"));

                filteredEvents.add(filteredEvent);
            }
        }

        JsonObject filteredJsonObject = new JsonObject();

        filteredJsonObject.add("events", filteredEvents);
        return filteredJsonObject;

    }

    private String formatDate(String dateString) {
        LocalDateTime startDate = LocalDateTime.parse(dateString,
                DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'Z'"));
        return startDate.format(DateTimeFormatter.ofPattern("dd-MM-yy HH:mm:ss"));
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
