package com.getyourway.api.services;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import okhttp3.*;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.io.IOException;


@Service
public class WeatherService {

    @Value("${openweathermap.api-key}")
    private String OPENWEATHERMAP_API_KEY;

    public String makeRequest() throws IOException {

        OkHttpClient client = new OkHttpClient();
        String city = "Paris";

        // Building the URL to get request
        HttpUrl url = new HttpUrl.Builder()
                .scheme("https")
                .host("api.openweathermap.org")
                .addPathSegment("data")
                .addPathSegment("2.5")
                .addPathSegment("forecast")
                .addQueryParameter("q",city)
                .addQueryParameter("appid",OPENWEATHERMAP_API_KEY)
                .build();

        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();

        Gson gson = new Gson();
        ResponseBody responseBody = client.newCall(request).execute().body();
        return responseBody.string();
        

    }
}

