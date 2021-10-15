package com.getyourway.api.controllers;

import com.getyourway.api.services.WeatherService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@CrossOrigin(origins = {"http://99.81.186.138:3000", "http://127.0.0.1:3000"})
public class WeatherController {
    private WeatherService service;

    public WeatherController(WeatherService service) {
        this.service = service;
    }

    @GetMapping("/weather")
    public String weather(@RequestParam double latitude, @RequestParam double longitude) {
        try {
            return service.getFiveDayForecast(latitude, longitude);
        } catch (IOException e){
            e.printStackTrace();
            return null;
        }
    }
}
