package com.getyourway.api.controllers;

import com.getyourway.api.services.AttractionsService;
import org.springframework.stereotype.Controller;

@Controller
public class AttractionsController {
    private AttractionsService service;

    public AttractionsController(AttractionsService service) {
        this.service = service;
    }
}
