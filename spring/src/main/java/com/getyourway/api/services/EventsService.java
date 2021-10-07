package com.getyourway.api.services;

import com.google.gson.Gson;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.ResponseBody;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class EventsService {

    @Value("${predicthq.api-key}")
    private String PREDICT_HQ_API_KEY;

    public String makeRequest() throws IOException {

        OkHttpClient client = new OkHttpClient();

        // Building the URL to get request
        Request request = new Request.Builder()
                .url("https://api.predicthq.com/v1/events?within=5km@48.858353,2.294464")
                .get()
                .addHeader("Authorization", "Bearer " + PREDICT_HQ_API_KEY)
                .build();

        ResponseBody responseBody = client.newCall(request).execute().body();
        String responseBodyString = responseBody.string();

        return responseBodyString;

    }

}
