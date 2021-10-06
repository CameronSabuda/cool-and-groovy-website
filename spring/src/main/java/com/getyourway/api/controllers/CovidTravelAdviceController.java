package com.getyourway.api.controllers;

import com.getyourway.api.services.CovidTravelAdviceService;
import org.springframework.stereotype.Controller;

@Controller
public class CovidTravelAdviceController {

    private CovidTravelAdviceService service;

    public CovidTravelAdviceController(CovidTravelAdviceService service) {
        this.service = service;
    }
}
