package com.getyourway.api.services;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EventsServiceTest {

    static double latitude;
    static double longitude;

    @BeforeAll
    static void setup() {
        latitude = 51.509865;
        longitude= 0.696969;
    }

    @AfterAll
    static void tearDown() {
    }

    @Test
    public void getEventsWithin5km_Coordinates_String() {

    }



}