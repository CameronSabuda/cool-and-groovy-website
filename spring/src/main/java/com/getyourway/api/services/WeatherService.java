package com.getyourway.api.services;

import com.google.gson.*;
import okhttp3.*;
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
        String url = "https://api.openweathermap.org/data/2.5/forecast?q=" + city +"&units=metric&appid=" + OPENWEATHERMAP_API_KEY;

        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();

        Gson gson = new Gson();
        ResponseBody responseBody = client.newCall(request).execute().body();
        String responseBodyString = responseBody.string();

        JsonElement oldJsonElement = new Gson().fromJson(responseBodyString, JsonElement.class);
        JsonObject oldJsonObject = oldJsonElement.getAsJsonObject();
        JsonObject newJsonObject = new JsonObject();

        JsonArray oldWeatherData = oldJsonObject.get("list").getAsJsonArray();
        JsonArray newWeatherData = new JsonArray();

        for (JsonElement oldWeather: oldWeatherData) {
            JsonObject oldWeatherObject = oldWeather.getAsJsonObject();

            JsonObject newWeather = new JsonObject();

            newWeather.add("date", oldWeatherObject.get("dt_txt"));
            newWeather.add("temp", oldWeatherObject.get("main").getAsJsonObject().get("temp"));
            newWeather.add("chance_of_rain", oldWeatherObject.get("pop"));
            newWeather.add("weather", oldWeatherObject.get("weather").getAsJsonArray());

            newWeatherData.add(newWeather);
        }

        newJsonObject.add("weather", newWeatherData);

        return newJsonObject.toString();
    }
}

