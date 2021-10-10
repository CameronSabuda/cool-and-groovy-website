
package com.getyourway.api.controllers;

import com.getyourway.api.services.CovidTravelAdviceService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class CovidTravelAdviceController {

    private CovidTravelAdviceService service;

    public CovidTravelAdviceController(CovidTravelAdviceService service) {
        this.service = service;
    }

    @GetMapping("/covid")
    public String covid(@RequestParam double latitude, @RequestParam double longitude) {
        try {
            return service.getCovidRiskLevel(latitude, longitude);
        } catch (IOException e){
            e.printStackTrace();
            return null;
        }
    }
}
