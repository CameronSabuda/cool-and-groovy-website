package com.getyourway.api.services;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class CovidTravelAdviceServiceUnitTest {

    @Test
    void getCovidRiskLevel_givenCoordinates_returnsFilteredString() throws IOException {
        //arrange
        double latitude = 51.509865;
        double longitude = -0.118092;

        String mockedResponseBodyString = "{\"api_status\":{\"request\":{\"item\":\"gb\"},\"reply\":{\"cache\":\"cached\",\"code\":200,\"status\":\"ok\",\"note\":\"The api works, we could match requested country code.\",\"count\":1}},\"data\":{\"GB\":{\"iso_alpha2\":\"GB\",\"name\":\"United Kingdom\",\"continent\":\"EU\",\"advisory\":{\"score\":4.0999999999999996447286321199499070644378662109375,\"sources_active\":7,\"message\":\"United Kingdom has a current risk level of 4.1 (out of 5). We advise: Please reconsider your need to travel to United Kingdom.\",\"updated\":\"2021-06-16 08:28:49\",\"source\":\"https:\\/\\/www.travel-advisory.info\\/united-kingdom\"}}}}";
        String expected = "{\"country_name\":\"United Kingdom\",\"risk_level\":\"4.1\"}";

        CovidTravelAdviceService covidTravelAdviceService = spy(new CovidTravelAdviceService());

        JsonObject mockedUnfilteredJsonObject = new Gson().fromJson(mockedResponseBodyString, JsonElement.class).getAsJsonObject();

        String countryCode = "GB";
        when(covidTravelAdviceService.convertCoordinatesToCountryCode(latitude, longitude)).thenReturn(countryCode);
        when(covidTravelAdviceService.fetchCovidRiskLevel(countryCode)).thenReturn(mockedUnfilteredJsonObject);

        //act
        String actual = covidTravelAdviceService.getCovidRiskLevel(latitude, longitude);

        //assert
        assertEquals(expected, actual);

    }

}