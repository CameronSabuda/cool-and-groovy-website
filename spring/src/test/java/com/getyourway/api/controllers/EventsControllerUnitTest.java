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
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.*;

//@ExtendWith(SpringExtension.class)
//@WebMvcTest(EventsController.class)
public class EventsControllerUnitTest {

//    @MockBean
//    EventsService eventsService;
//
//    @Autowired
//    MockMvc mockMvc;

//    @Autowired
//    ObjectMapper mapper;

    static double latitude_1, latitude_2;
    static double longitude_1, longitude_2;

    @BeforeAll
    static void setUp() {

    }

    @AfterAll
    static void tearDown() {
//        latitude_1 = 0;
//        longitude_1 = 0;
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
    public void getEventsWithin5km_givenValidCoordinates_shouldReturnTheSameStringTheEventServiceReturns() throws IOException {
        //arrange
        latitude_1 = 51.509865;
        longitude_1= -0.118092;

        EventsService eventsService = mock(EventsService.class);
        when(eventsService.getEventsWithin5km(latitude_1, longitude_1)).thenReturn("Bonfire Night Firework Displays in London");

        //act
        EventsController eventsController = new EventsController(eventsService);
        String actual = eventsController.getEventsWithin5km(latitude_1, longitude_1);

        //assert
        String expected = "Bonfire Night Firework Displays in London";
        assertEquals(expected, actual);
    }
}