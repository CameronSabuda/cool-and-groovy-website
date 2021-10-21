package com.getyourway.api.controllers;

import com.getyourway.api.services.EventsService;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class EventsControllerUnitTest {

    @Test
    public void getEventsWithin5km_givenCoordinates_returnsTheSameStringTheEventServiceReturns() throws IOException {
        //arrange
        double latitude = 51.509865;
        double longitude = -0.118092;

        EventsService mockedEventsService = mock(EventsService.class);
        when(mockedEventsService.getEventsWithin5km(latitude, longitude)).thenReturn("Bonfire Night Firework Displays in London");
        EventsController eventsController = new EventsController(mockedEventsService);

        //act
        String actual = eventsController.getEventsWithin5km(latitude, longitude);

        //assert
        String expected = "Bonfire Night Firework Displays in London";
        assertEquals(expected, actual);
    }
}