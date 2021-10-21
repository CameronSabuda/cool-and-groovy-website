package com.getyourway.api.controllers;

import com.getyourway.api.services.EventsService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

//Testing the integration between the controller and Spring
@WebMvcTest
public class EventsControllerIntegrationTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private EventsService eventsService;
//
//    @Test
//    void covid_givenCoordinates_responseOkAndReturnsTheSameStringTheCovidTravelAdviceServiceReturns()
//            throws Exception {
//
//        double latitude = 51.509865;
//        double longitude = -0.118092;
//
//        when(eventsService
//                .getEventsWithin5km(latitude, longitude))
//                .thenReturn("Bonfire Night Firework Displays in London");
//
//        mockMvc.perform(get(String.format("/events?latitude=%f&longitude=%f", latitude, longitude)))
//                .andDo(print())
//                .andExpect(status().isOk())
//                .andExpect(content().string(equalTo("Bonfire Night Firework Displays in London")));
//    }
}
