package com.getyourway.api.controllers;

import com.getyourway.api.services.WeatherService;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class WeatherControllerUnitTest {

    @Test
    public void weather_givenCoordinates_returnsTheSameStringTheWeatherServiceReturns() throws IOException {
        //arrange
        double latitude = 51.509865;
        double longitude = -0.118092;

        WeatherService mockedWeatherService = mock(WeatherService.class);
        when(mockedWeatherService.getFiveDayForecast(latitude, longitude)).thenReturn("Weather Forecasts");
        WeatherController weatherController = new WeatherController(mockedWeatherService);

        //act
        String actual = weatherController.weather(latitude, longitude);

        //assert
        String expected = "Weather Forecasts";
        assertEquals(expected, actual);
    }
}