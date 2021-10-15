package com.getyourway.api.services;

import com.google.gson.*;
import okhttp3.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@Service
public class WeatherService {

    @Value("${openweathermap.api-key}")
    private String OPENWEATHERMAP_API_KEY;

    public String getFiveDayForecast(double latitude, double longitude) throws IOException {

        JsonObject unfilteredJsonObject = fetchWeatherData(latitude, longitude);


        return filterExternalJsonObject(unfilteredJsonObject).toString();
    }

    private JsonObject filterExternalJsonObject(JsonObject unfilteredJsonObject) {
        JsonArray unfilteredWeatherDataList = unfilteredJsonObject.get("list").getAsJsonArray();
        JsonArray filteredWeatherDataList = new JsonArray();

        for (JsonElement unfilteredWeatherDataElement : unfilteredWeatherDataList) {
            JsonObject unfilteredWeatherDataObject = unfilteredWeatherDataElement.getAsJsonObject();

            String dateTimeString = unfilteredWeatherDataObject.get("dt_txt").getAsString();
            String timeString = dateTimeString.split(" ")[1];

            if (timeString.equals("12:00:00")) {
                JsonObject filteredWeatherDataItem = new JsonObject();

                String day = convertDateTimeToDay(dateTimeString);
                filteredWeatherDataItem.add("day", new JsonPrimitive(day));
                float temperature = unfilteredWeatherDataObject.get("main").getAsJsonObject().get("temp").getAsFloat();
                int intTemperature = Math.round(temperature);
                filteredWeatherDataItem.add("temp", new JsonPrimitive(intTemperature));

                int chanceOfRain = Math.round(unfilteredWeatherDataObject.get("pop").getAsFloat() * 100);

                filteredWeatherDataItem.add("chance_of_rain", new JsonPrimitive(chanceOfRain));

                JsonObject weatherDescriptionObject = unfilteredWeatherDataObject
                        .get("weather").getAsJsonArray()
                        .get(0).getAsJsonObject();

                String weatherType = weatherDescriptionObject.get("description").getAsString();

                filteredWeatherDataItem.add("weather_type", new JsonPrimitive(StringUtils.capitalize(weatherType)));
                filteredWeatherDataItem.add("icon", weatherDescriptionObject.get("icon"));

                filteredWeatherDataList.add(filteredWeatherDataItem);
            }

        }
        JsonObject filteredJsonObject = new JsonObject();

        filteredJsonObject.add("weather", filteredWeatherDataList);

        return filteredJsonObject;

    }

    private JsonObject fetchWeatherData(double latitude, double longitude) throws IOException {
        OkHttpClient client = new OkHttpClient();
        String url = "https://api.openweathermap.org/data/2.5/forecast?lat=" + latitude + "&lon=" + longitude + "&units=metric&appid=" + OPENWEATHERMAP_API_KEY;

        Request request = new Request.Builder()
                .url(url)
                .get()
                .build();

        ResponseBody responseBody = client.newCall(request).execute().body();
        String responseBodyString = null != responseBody ? responseBody.string() : "{}";
        System.out.println(responseBodyString);

        JsonElement unfilteredJsonElement = new Gson().fromJson(responseBodyString, JsonElement.class);
        return unfilteredJsonElement.getAsJsonObject();
    }

    private String convertDateTimeToDay(String dateString) {
        LocalDateTime startDate = LocalDateTime.parse(dateString, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        return StringUtils.capitalize(startDate.getDayOfWeek().name().toLowerCase());
    }
}

