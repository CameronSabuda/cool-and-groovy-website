package com.getyourway.api.controllers;

import com.getyourway.api.services.AttractionsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

@Controller
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AttractionsController {
    private AttractionsService service;

    public AttractionsController(AttractionsService service) {
        this.service = service;
    }
}
