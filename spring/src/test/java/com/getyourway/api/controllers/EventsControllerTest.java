package com.getyourway.api.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.getyourway.api.services.EventsService;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.*;

//@ExtendWith(SpringExtension.class)
//@WebMvcTest(EventsController.class)
public class EventsControllerTest {

//    @MockBean
//    EventsService eventsService;
//
//    @Autowired
//    MockMvc mockMvc;

//    @Autowired
//    ObjectMapper mapper;

    static double londonLatitude;
    static double londonLongitude;

    @BeforeAll
    static void setUp() {
        londonLatitude = 51.509865;
        londonLongitude= -0.118092;
    }

    @AfterAll
    static void tearDown() {

    }

//    @Test
//    public void getEventsWithin5km() throws Exception {
////        when(patientRecordRepository.findAll()).thenReturn(records);
//        when(eventsService.getEventsWithin5km(londonLatitude, londonLongitude)).thenReturn(""); //then Return to be updated
//
//        mockMvc.perform(MockMvcRequestBuilders
//                        .get("/events")
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$[2].city", is("London"))); //jasonPath to be updated
//
//
//    }

    @Test
    public void getEventsWithin5km() throws IOException {

        String expected = "Hello";
        EventsService eventsService = Mockito.mock(EventsService.class);
        when(eventsService.getEventsWithin5km(londonLatitude, londonLongitude)).thenReturn(expected);
        EventsController eventsController = new EventsController(eventsService);
        assertEquals(expected, eventsController.getEventsWithin5km(londonLatitude, londonLongitude));
    }


}