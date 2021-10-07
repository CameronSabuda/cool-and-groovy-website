package com.getyourway.api.controllers;

import com.getyourway.api.services.EventsService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
public class EventsController {

    private EventsService service;

    public EventsController(EventsService service) {
        this.service = service;
    }

    @GetMapping("/events")
    public String getAllData() {
        try {
            return service.makeRequest();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}
