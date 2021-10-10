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

    public String getFiveDayForecast(double latitude, double longitude) throws IOException {

        JsonObject unfilteredJsonObject = fetchWeatherData(latitude, longitude);


        return filterExternalJsonObject(unfilteredJsonObject).toString();
    }

    private JsonObject filterExternalJsonObject(JsonObject unfilteredJsonObject) {
        JsonArray unfilteredWeatherDataList = unfilteredJsonObject.get("list").getAsJsonArray();
        JsonArray filteredWeatherDataList = new JsonArray();

        for (JsonElement unfilteredWeatherDataElement: unfilteredWeatherDataList) {
            JsonObject unfilteredWeatherDataObject = unfilteredWeatherDataElement.getAsJsonObject();

            String dateTimeString = unfilteredWeatherDataObject.get("dt_txt").getAsString();
            String timeString = dateTimeString.split(" ")[1];

            if (timeString.equals("12:00:00")){

                JsonObject filteredWeatherDataItem = new JsonObject();

                String unixTimestamp = unfilteredWeatherDataObject.get("dt").getAsString();
                String date = formatDate(unixTimestamp);
                filteredWeatherDataItem.add("date",new JsonPrimitive(date));
                filteredWeatherDataItem.add("temp", unfilteredWeatherDataObject.get("main").getAsJsonObject().get("temp"));
                filteredWeatherDataItem.add("chance_of_rain", unfilteredWeatherDataObject.get("pop"));
                filteredWeatherDataItem.add("weather", unfilteredWeatherDataObject.get("weather").getAsJsonArray());



                filteredWeatherDataList.add(filteredWeatherDataItem);

            }

        }
        JsonObject filteredJsonObject = new JsonObject();

        filteredJsonObject.add("weather", filteredWeatherDataList);

        return filteredJsonObject;

    }

    private JsonObject fetchWeatherData(double latitude, double longitude) throws IOException {
        OkHttpClient client = new OkHttpClient();
        String url = "https://api.openweathermap.org/data/2.5/forecast?lat=" + latitude + "&lon=" + longitude +"&units=metric&appid=" + OPENWEATHERMAP_API_KEY;

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

    private String formatDate(String unixString){
        long unixSeconds = Long.parseLong(unixString);
        Date date = new Date(unixSeconds*1000L);
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT-0"));

        return sdf.format(date);
    }
}

