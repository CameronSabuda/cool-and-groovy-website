package com.getyourway.api.controllers;

import com.getyourway.api.services.CovidTravelAdviceService;
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

@WebMvcTest
public class CovidTravelAdviceControllerIntegrationTest {
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private CovidTravelAdviceService covidTravelAdviceService;
//
//    @Test
//    void covid_givenCoordinates_responseOkAndReturnsTheSameStringTheCovidTravelAdviceServiceReturns()
//            throws Exception {
//
//        double latitude = 51.509865;
//        double longitude = -0.118092;
//
//        when(covidTravelAdviceService
//                .getCovidRiskLevel(latitude, longitude))
//                .thenReturn("United Kingdom: Risk Level 4.1");
//
//        mockMvc.perform(get(String.format("/covid?latitude=%f&longitude=%f", latitude, longitude)))
//                .andDo(print())
//                .andExpect(status().isOk())
//                .andExpect(content().string(equalTo("United Kingdom: Risk Level 4.1")));
//        verify(covidTravelAdviceService).getCovidRiskLevel(latitude, longitude);
//    }
}
