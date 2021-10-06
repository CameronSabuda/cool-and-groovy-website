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
        String city = "Paris";

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

        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }
}