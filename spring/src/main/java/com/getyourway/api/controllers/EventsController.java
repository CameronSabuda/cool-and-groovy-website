package com.getyourway.api.controllers;

import com.getyourway.api.services.EventsService;
import org.springframework.stereotype.Controller;

@Controller
public class EventsController {

    private EventsService service;

    public EventsController(EventsService service) {
        this.service = service;
    }
}
