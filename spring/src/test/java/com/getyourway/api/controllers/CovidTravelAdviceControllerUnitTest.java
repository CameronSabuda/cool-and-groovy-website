package com.getyourway.api.controllers;

import com.getyourway.api.services.CovidTravelAdviceService;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CovidTravelAdviceControllerUnitTest {

    @Test
    void covid_givenCoordinates_returnsTheSameStringTheCovidTravelAdviceServiceReturns() throws IOException {
        //arrange
        double latitude = 51.509865;
        double longitude = -0.118092;

        CovidTravelAdviceService mockedCovidTravelAdviceService = mock(CovidTravelAdviceService.class);
        when(mockedCovidTravelAdviceService.getCovidRiskLevel(latitude, longitude)).thenReturn("United Kingdom: Risk Level 4.1");
        CovidTravelAdviceController covidTravelAdviceController = new CovidTravelAdviceController(mockedCovidTravelAdviceService);

        //act
        String actual = covidTravelAdviceController.covid(latitude, longitude);

        //assert
        String expected = "United Kingdom: Risk Level 4.1";
        assertEquals(expected, actual);
    }

}