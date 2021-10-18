package com.getyourway.api.controllers;

import com.getyourway.api.services.CovidTravelAdviceService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

@Controller
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CovidTravelAdviceController {

    private CovidTravelAdviceService service;

    public CovidTravelAdviceController(CovidTravelAdviceService service) {
        this.service = service;
    }
}
