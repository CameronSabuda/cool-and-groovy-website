package com.getyourway.api.services;

import com.google.gson.*;
import okhttp3.*;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class CovidTravelAdviceService {

    public String getCovidRiskLevel(double latitude, double longitude) throws IOException {
        String countryCode = convertCoordinates(latitude, longitude);

        JsonObject unfilteredJsonObject = fetchCovidRiskLevel(countryCode);

        JsonObject filteredJsonObject = filterExternalJsonObject(unfilteredJsonObject, countryCode);

        return filteredJsonObject.toString();
    }

    public JsonObject fetchCovidRiskLevel(String countryCode) throws IOException {
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

    public JsonObject filterExternalJsonObject(JsonObject unfilteredJsonObject, String countryCode) {
        JsonObject unfilteredCovidDataObject = unfilteredJsonObject
                .get("data").getAsJsonObject();
        // .get(countryCode).getAsJsonObject()
        // .get("advisory").getAsJsonObject();

        // JsonObject filteredCovidDataObject = new JsonObject();
        //
        // filteredCovidDataObject.add("risk_level", unfilteredCovidDataObject.get("score"));
        // filteredCovidDataObject.add("updated_time", unfilteredCovidDataObject.get("updated"));
        //
        // return filteredCovidDataObject;
        return unfilteredJsonObject;
    }


    public String convertCoordinates(double latitude, double longitude) throws IOException {
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url(String.format("http://api.geonames.org/countryCode?lat=%f&lng=%f&username=ryansky&radius=5", latitude, longitude))
                .get()
                .build();

        ResponseBody responseBody = client.newCall(request).execute().body();
        // String responseBodyString = null != responseBody ? responseBody.string() : "{}";
        String responseBodyString = responseBody.string();

        return responseBodyString;
    }
}