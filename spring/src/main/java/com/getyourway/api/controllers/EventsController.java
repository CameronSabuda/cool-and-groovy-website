package com.getyourway.api.controllers;

import com.getyourway.api.services.EventsService;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class EventsController {

    private EventsService service;

    public EventsController(EventsService service) {
        this.service = service;
    }

    @GetMapping("/events")
    public String getEventsWithin5km(@RequestParam double latitude, @RequestParam double longitude) {
        try {
            return service.getEventsWithin5km(latitude, longitude);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

}
