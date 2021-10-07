package com.getyourway.api.services;

import com.google.gson.*;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;


@Service
public class WeatherService {

    @Value("${openweathermap.api-key}")
    private String OPENWEATHERMAP_API_KEY;

    public String getFiveDayWeatherForecast(double latitude, double longitude) throws IOException {

        // We're using okHttp due cleaner code syntax
        OkHttpClient client = new OkHttpClient();
        String url = "https://api.openweathermap.org/data/2.5/forecast?lat=" + latitude + "&lon=" + longitude +"&units=metric&appid=" + OPENWEATHERMAP_API_KEY;

        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();

        // Using Gson due to great performance, and more understandable methods for parsing json object
        Gson gson = new Gson();
        ResponseBody responseBody = client.newCall(request).execute().body();
        String responseBodyString = responseBody.string();

        JsonElement oldJsonElement = new Gson().fromJson(responseBodyString, JsonElement.class);
        JsonObject returnedJsonObject = oldJsonElement.getAsJsonObject();
        JsonObject formattedJsonObject = new JsonObject();

        JsonArray returnedWeatherData = returnedJsonObject.get("list").getAsJsonArray();
        JsonArray formattedWeatherData = new JsonArray();

        for (JsonElement oldWeather: returnedWeatherData) {
            JsonObject oldWeatherObject = oldWeather.getAsJsonObject();

            JsonObject newWeather = new JsonObject();

            String unixTimestamp = oldWeatherObject.get("dt").getAsString();
            String date = formatDate(unixTimestamp);
            newWeather.add("date",new JsonPrimitive(date));
            newWeather.add("temp", oldWeatherObject.get("main").getAsJsonObject().get("temp"));
            newWeather.add("chance_of_rain", oldWeatherObject.get("pop"));
            newWeather.add("weather", oldWeatherObject.get("weather").getAsJsonArray());

            formattedWeatherData.add(newWeather);
        }

        formattedJsonObject.add("weather", formattedWeatherData);

        return formattedJsonObject.toString();
    }

    private String formatDate(String unixString){
        long unixSeconds = Long.parseLong(unixString);
        Date date = new Date(unixSeconds*1000L);
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT-0"));

        return sdf.format(date);
    }
}

