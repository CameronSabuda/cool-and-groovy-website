package com.getyourway.api.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class EventsControllerAcceptanceTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @Test
//    void covid_givenCoordinates_responseOkAndReturnsTheSameStringTheEventsServiceReturns()
//            throws Exception {
//
//        double latitude = 51.509865;
//        double longitude = -0.118092;
//
//        mockMvc.perform(get(String.format("/events?latitude=%f&longitude=%f", latitude, longitude)))
//                .andDo(print())
//                .andExpect(status().isOk())
//                .andExpect(content().string(equalTo("")));
//    }
}
