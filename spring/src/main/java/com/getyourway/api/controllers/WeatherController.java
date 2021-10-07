package com.getyourway.api.controllers;

import com.getyourway.api.services.WeatherService;
import com.google.gson.JsonIOException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class WeatherController {
    private WeatherService service;

    public WeatherController(WeatherService service) {
        this.service = service;
    }

    @GetMapping("/weather")
    public String weather() throws IOException {
        try {
            return service.makeRequest();
        } catch (IOException | JsonIOException e){
            e.printStackTrace();
            return null;
        }
    }
}
