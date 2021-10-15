package com.getyourway.api.services;

import com.google.gson.*;
import okhttp3.*;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static java.awt.SystemColor.text;

@Service
public class CovidTravelAdviceService {

    public String getCovidRiskLevel(double latitude, double longitude) throws IOException {
        String countryCode = convertCoordinates(latitude, longitude);

        JsonObject unfilteredJsonObject = fetchCovidRiskLevel(countryCode);

        JsonObject filteredJsonObject = filterExternalJsonObject(unfilteredJsonObject, countryCode);

        return filteredJsonObject.toString();
    }

    private JsonObject fetchCovidRiskLevel(String countryCode) throws IOException {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(String.format("https://www.travel-advisory.info/api?countrycode=%s", countryCode))
                .get()
                .build();

        ResponseBody responseBody = client.newCall(request).execute().body();
        String responseBodyString = null != responseBody ? responseBody.string() : "{}";

        JsonElement unfilteredJsonElement = new Gson().fromJson(responseBodyString, JsonElement.class);
        return unfilteredJsonElement.getAsJsonObject();
    }

    private JsonObject filterExternalJsonObject(JsonObject unfilteredJsonObject, String countryCode) {
        JsonObject unfilteredCovidObject = unfilteredJsonObject
                .getAsJsonObject("data")
                .getAsJsonObject(countryCode)
                .getAsJsonObject("advisory");

        JsonObject filteredCovidDataObject = new JsonObject();

        String score = String.format("%.1f", unfilteredCovidObject.get("score").getAsFloat());
        filteredCovidDataObject.add("risk_level", new JsonPrimitive(score));

        String formattedDate = formatDate(unfilteredCovidObject.get("updated").getAsString());
        filteredCovidDataObject.add("updated_time", new JsonPrimitive(formattedDate));

        JsonObject filteredJSONObject = new JsonObject();
        filteredJSONObject.add("risk", filteredCovidDataObject);

        return filteredJSONObject;
    }


    private String convertCoordinates(double latitude, double longitude) throws IOException {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(String.format("http://api.geonames.org/countryCode?lat=%f&lng=%f&username=ryansky&radius=5", latitude, longitude))
                .get()
                .build();

        ResponseBody responseBody = client.newCall(request).execute().body();
        String responseBodyString = null != responseBody ? responseBody.string() : "{}";
        String formattedString = responseBodyString.replace("\n", "").replace("\r", "");

        return formattedString;
    }

    private String formatDate(String dateString) {
        LocalDateTime startDate = LocalDateTime.parse(dateString,
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        return startDate.format(DateTimeFormatter.ofPattern("dd-MM-yy HH:mm:ss"));
    }
}
