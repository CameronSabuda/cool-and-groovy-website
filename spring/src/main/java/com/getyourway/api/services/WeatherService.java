package com.getyourway.api.services;

import com.fasterxml.jackson.databind.util.JSONPObject;
import okhttp3.HttpUrl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.io.IOException;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;

@Service
public class WeatherService {

    @Value("${openweathermap.api-key}")
    private String OPENWEATHERMAP_API_KEY;

    public String makeRequest() throws IOException {

        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder()
                .url("https://community-open-weather-map.p.rapidapi.com/forecast?q=Paris&units=metric")
                .get()
                .addHeader("x-rapidapi-host", "community-open-weather-map.p.rapidapi.com")
                .addHeader("x-rapidapi-key", "OPENWEATHERMAP_API_KEY")
                .build();

        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }
}



// OkHttpClient client = new OkHttpClient();
//
// HttpUrl.Builder urlBuilder = HttpUrl.parse("https://community-open-weather-map.p.rapidapi.com/forecast").newBuilder();
// urlBuilder.addQueryParameter("q", "Paris");
// urlBuilder.addQueryParameter("units", "metric");
// String url = urlBuilder.build().toString();
//
// Request request = new Request.Builder()
//         .header("Authorization",OPENWEATHERMAP_API_KEY)
//         .url(url)
//         .build();
//
//
// Response response = client.newCall(request).execute();
// return response.body().string();