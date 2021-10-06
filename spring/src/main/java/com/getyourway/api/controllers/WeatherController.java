package com.getyourway.api.controllers;

import com.getyourway.api.services.WeatherService;
import org.springframework.stereotype.Controller;

@Controller
public class WeatherController {
    private WeatherService service;

    public WeatherController(WeatherService service) {
        this.service = service;
    }
}
