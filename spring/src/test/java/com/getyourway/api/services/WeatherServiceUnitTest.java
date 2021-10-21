package com.getyourway.api.services;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class WeatherServiceUnitTest {

    @Test
    void getFiveDayForecast_givenCoordinates_returnFilteredString() throws IOException {
        //arrange
        double latitude = 51.509865;
        double longitude = -0.118092;

        String mockedResponseBodyString = "{\"cod\":\"200\",\"message\":0,\"cnt\":40,\"list\":[{\"dt\":1634850000,\"main\":{\"temp\":7.78,\"feels_like\":6.17,\"temp_min\":7.78,\"temp_max\":8.93,\"pressure\":1017,\"sea_level\":1017,\"grnd_level\":1017,\"humidity\":72,\"temp_kf\":-1.15},\"weather\":[{\"id\":801,\"main\":\"Clouds\",\"description\":\"few clouds\",\"icon\":\"02n\"}],\"clouds\":{\"all\":19},\"wind\":{\"speed\":2.53,\"deg\":268,\"gust\":7.28},\"visibility\":10000,\"pop\":0,\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2021-10-21 21:00:00\"},{\"dt\":1634860800,\"main\":{\"temp\":7.77,\"feels_like\":5.63,\"temp_min\":7.77,\"temp_max\":8.05,\"pressure\":1018,\"sea_level\":1018,\"grnd_level\":1018,\"humidity\":72,\"temp_kf\":-0.28},\"weather\":[{\"id\":802,\"main\":\"Clouds\",\"description\":\"scattered clouds\",\"icon\":\"03n\"}],\"clouds\":{\"all\":26},\"wind\":{\"speed\":3.33,\"deg\":261,\"gust\":9.57},\"visibility\":10000,\"pop\":0,\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2021-10-22 00:00:00\"},{\"dt\":1634871600,\"main\":{\"temp\":7.82,\"feels_like\":5.21,\"temp_min\":7.82,\"temp_max\":7.82,\"pressure\":1019,\"sea_level\":1019,\"grnd_level\":1018,\"humidity\":74,\"temp_kf\":0},\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"clear sky\",\"icon\":\"01n\"}],\"clouds\":{\"all\":5},\"wind\":{\"speed\":4.22,\"deg\":268,\"gust\":10.98},\"visibility\":10000,\"pop\":0,\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2021-10-22 03:00:00\"},{\"dt\":1634882400,\"main\":{\"temp\":7.38,\"feels_like\":4.61,\"temp_min\":7.38,\"temp_max\":7.38,\"pressure\":1019,\"sea_level\":1019,\"grnd_level\":1018,\"humidity\":75,\"temp_kf\":0},\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"clear sky\",\"icon\":\"01n\"}],\"clouds\":{\"all\":9},\"wind\":{\"speed\":4.35,\"deg\":264,\"gust\":11.65},\"visibility\":10000,\"pop\":0,\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2021-10-22 06:00:00\"},{\"dt\":1634893200,\"main\":{\"temp\":9.07,\"feels_like\":6.56,\"temp_min\":9.07,\"temp_max\":9.07,\"pressure\":1021,\"sea_level\":1021,\"grnd_level\":1020,\"humidity\":68,\"temp_kf\":0},\"weather\":[{\"id\":802,\"main\":\"Clouds\",\"description\":\"scattered clouds\",\"icon\":\"03d\"}],\"clouds\":{\"all\":40},\"wind\":{\"speed\":4.66,\"deg\":261,\"gust\":11.9},\"visibility\":10000,\"pop\":0,\"sys\":{\"pod\":\"d\"},\"dt_txt\":\"2021-10-22 09:00:00\"},{\"dt\":1634904000,\"main\":{\"temp\":11.04,\"feels_like\":9.87,\"temp_min\":11.04,\"temp_max\":11.04,\"pressure\":1021,\"sea_level\":1021,\"grnd_level\":1021,\"humidity\":64,\"temp_kf\":0},\"weather\":[{\"id\":803,\"main\":\"Clouds\",\"description\":\"broken clouds\",\"icon\":\"04d\"}],\"clouds\":{\"all\":70},\"wind\":{\"speed\":4.45,\"deg\":271,\"gust\":10.2},\"visibility\":10000,\"pop\":0,\"sys\":{\"pod\":\"d\"},\"dt_txt\":\"2021-10-22 12:00:00\"},{\"dt\":1634914800,\"main\":{\"temp\":12.13,\"feels_like\":11.17,\"temp_min\":12.13,\"temp_max\":12.13,\"pressure\":1022,\"sea_level\":1022,\"grnd_level\":1021,\"humidity\":68,\"temp_kf\":0},\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04d\"}],\"clouds\":{\"all\":100},\"wind\":{\"speed\":3.98,\"deg\":276,\"gust\":8.07},\"visibility\":10000,\"pop\":0,\"sys\":{\"pod\":\"d\"},\"dt_txt\":\"2021-10-22 15:00:00\"},{\"dt\":1634925600,\"main\":{\"temp\":11.19,\"feels_like\":10.27,\"temp_min\":11.19,\"temp_max\":11.19,\"pressure\":1023,\"sea_level\":1023,\"grnd_level\":1022,\"humidity\":73,\"temp_kf\":0},\"weather\":[{\"id\":500,\"main\":\"Rain\",\"description\":\"light rain\",\"icon\":\"10n\"}],\"clouds\":{\"all\":98},\"wind\":{\"speed\":3,\"deg\":282,\"gust\":8.23},\"visibility\":10000,\"pop\":0.2,\"rain\":{\"3h\":0.25},\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2021-10-22 18:00:00\"},{\"dt\":1634936400,\"main\":{\"temp\":10.2,\"feels_like\":9.34,\"temp_min\":10.2,\"temp_max\":10.2,\"pressure\":1025,\"sea_level\":1025,\"grnd_level\":1024,\"humidity\":79,\"temp_kf\":0},\"weather\":[{\"id\":500,\"main\":\"Rain\",\"description\":\"light rain\",\"icon\":\"10n\"}],\"clouds\":{\"all\":88},\"wind\":{\"speed\":2.2,\"deg\":280,\"gust\":5.95},\"visibility\":10000,\"pop\":0.2,\"rain\":{\"3h\":0.12},\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2021-10-22 21:00:00\"},{\"dt\":1634947200,\"main\":{\"temp\":9.22,\"feels_like\":8.72,\"temp_min\":9.22,\"temp_max\":9.22,\"pressure\":1025,\"sea_level\":1025,\"grnd_level\":1025,\"humidity\":85,\"temp_kf\":0},\"weather\":[{\"id\":803,\"main\":\"Clouds\",\"description\":\"broken clouds\",\"icon\":\"04n\"}],\"clouds\":{\"all\":61},\"wind\":{\"speed\":1.54,\"deg\":264,\"gust\":2.83},\"visibility\":10000,\"pop\":0,\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2021-10-23 00:00:00\"},{\"dt\":1634958000,\"main\":{\"temp\":8.62,\"feels_like\":7.86,\"temp_min\":8.62,\"temp_max\":8.62,\"pressure\":1025,\"sea_level\":1025,\"grnd_level\":1024,\"humidity\":88,\"temp_kf\":0},\"weather\":[{\"id\":801,\"main\":\"Clouds\",\"description\":\"few clouds\",\"icon\":\"02n\"}],\"clouds\":{\"all\":21},\"wind\":{\"speed\":1.7,\"deg\":254,\"gust\":3.06},\"visibility\":10000,\"pop\":0,\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2021-10-23 03:00:00\"},{\"dt\":1634968800,\"main\":{\"temp\":7.93,\"feels_like\":7.08,\"temp_min\":7.93,\"temp_max\":7.93,\"pressure\":1025,\"sea_level\":1025,\"grnd_level\":1024,\"humidity\":86,\"temp_kf\":0},\"weather\":[{\"id\":801,\"main\":\"Clouds\",\"description\":\"few clouds\",\"icon\":\"02n\"}],\"clouds\":{\"all\":16},\"wind\":{\"speed\":1.69,\"deg\":232,\"gust\":3.42},\"visibility\":10000,\"pop\":0,\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2021-10-23 06:00:00\"},{\"dt\":1634979600,\"main\":{\"temp\":9.96,\"feels_like\":9.09,\"temp_min\":9.96,\"temp_max\":9.96,\"pressure\":1026,\"sea_level\":1026,\"grnd_level\":1025,\"humidity\":72,\"temp_kf\":0},\"weather\":[{\"id\":803,\"main\":\"Clouds\",\"description\":\"broken clouds\",\"icon\":\"04d\"}],\"clouds\":{\"all\":77},\"wind\":{\"speed\":2.07,\"deg\":217,\"gust\":4.01},\"visibility\":10000,\"pop\":0,\"sys\":{\"pod\":\"d\"},\"dt_txt\":\"2021-10-23 09:00:00\"},{\"dt\":1634990400,\"main\":{\"temp\":13.3,\"feels_like\":12.2,\"temp_min\":13.3,\"temp_max\":13.3,\"pressure\":1025,\"sea_level\":1025,\"grnd_level\":1024,\"humidity\":58,\"temp_kf\":0},\"weather\":[{\"id\":803,\"main\":\"Clouds\",\"description\":\"broken clouds\",\"icon\":\"04d\"}],\"clouds\":{\"all\":67},\"wind\":{\"speed\":3.73,\"deg\":220,\"gust\":6.12},\"visibility\":10000,\"pop\":0,\"sys\":{\"pod\":\"d\"},\"dt_txt\":\"2021-10-23 12:00:00\"},{\"dt\":1635001200,\"main\":{\"temp\":13.48,\"feels_like\":12.42,\"temp_min\":13.48,\"temp_max\":13.48,\"pressure\":1024,\"sea_level\":1024,\"grnd_level\":1023,\"humidity\":59,\"temp_kf\":0},\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04d\"}],\"clouds\":{\"all\":100},\"wind\":{\"speed\":3.73,\"deg\":213,\"gust\":6.38},\"visibility\":10000,\"pop\":0,\"sys\":{\"pod\":\"d\"},\"dt_txt\":\"2021-10-23 15:00:00\"},{\"dt\":1635012000,\"main\":{\"temp\":11.41,\"feels_like\":10.41,\"temp_min\":11.41,\"temp_max\":11.41,\"pressure\":1024,\"sea_level\":1024,\"grnd_level\":1023,\"humidity\":69,\"temp_kf\":0},\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04n\"}],\"clouds\":{\"all\":85},\"wind\":{\"speed\":2.91,\"deg\":190,\"gust\":7.95},\"visibility\":10000,\"pop\":0,\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2021-10-23 18:00:00\"},{\"dt\":1635022800,\"main\":{\"temp\":10.38,\"feels_like\":9.35,\"temp_min\":10.38,\"temp_max\":10.38,\"pressure\":1023,\"sea_level\":1023,\"grnd_level\":1023,\"humidity\":72,\"temp_kf\":0},\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04n\"}],\"clouds\":{\"all\":87},\"wind\":{\"speed\":2.85,\"deg\":186,\"gust\":9.73},\"visibility\":10000,\"pop\":0,\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2021-10-23 21:00:00\"},{\"dt\":1635033600,\"main\":{\"temp\":10.19,\"feels_like\":9.22,\"temp_min\":10.19,\"temp_max\":10.19,\"pressure\":1022,\"sea_level\":1022,\"grnd_level\":1021,\"humidity\":75,\"temp_kf\":0},\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04n\"}],\"clouds\":{\"all\":94},\"wind\":{\"speed\":2.9,\"deg\":170,\"gust\":10.43},\"visibility\":10000,\"pop\":0,\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2021-10-24 00:00:00\"},{\"dt\":1635044400,\"main\":{\"temp\":9.73,\"feels_like\":8.37,\"temp_min\":9.73,\"temp_max\":9.73,\"pressure\":1020,\"sea_level\":1020,\"grnd_level\":1020,\"humidity\":78,\"temp_kf\":0},\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04n\"}],\"clouds\":{\"all\":100},\"wind\":{\"speed\":2.7,\"deg\":170,\"gust\":9.98},\"visibility\":10000,\"pop\":0,\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2021-10-24 03:00:00\"},{\"dt\":1635055200,\"main\":{\"temp\":9.72,\"feels_like\":7.97,\"temp_min\":9.72,\"temp_max\":9.72,\"pressure\":1019,\"sea_level\":1019,\"grnd_level\":1019,\"humidity\":76,\"temp_kf\":0},\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04n\"}],\"clouds\":{\"all\":100},\"wind\":{\"speed\":3.36,\"deg\":174,\"gust\":11.22},\"visibility\":10000,\"pop\":0,\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2021-10-24 06:00:00\"},{\"dt\":1635066000,\"main\":{\"temp\":11.39,\"feels_like\":10.39,\"temp_min\":11.39,\"temp_max\":11.39,\"pressure\":1019,\"sea_level\":1019,\"grnd_level\":1018,\"humidity\":69,\"temp_kf\":0},\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04d\"}],\"clouds\":{\"all\":100},\"wind\":{\"speed\":3.75,\"deg\":174,\"gust\":9.83},\"visibility\":10000,\"pop\":0,\"sys\":{\"pod\":\"d\"},\"dt_txt\":\"2021-10-24 09:00:00\"},{\"dt\":1635076800,\"main\":{\"temp\":13.56,\"feels_like\":12.56,\"temp_min\":13.56,\"temp_max\":13.56,\"pressure\":1018,\"sea_level\":1018,\"grnd_level\":1017,\"humidity\":61,\"temp_kf\":0},\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04d\"}],\"clouds\":{\"all\":100},\"wind\":{\"speed\":4.44,\"deg\":187,\"gust\":8.42},\"visibility\":10000,\"pop\":0,\"sys\":{\"pod\":\"d\"},\"dt_txt\":\"2021-10-24 12:00:00\"},{\"dt\":1635087600,\"main\":{\"temp\":13.91,\"feels_like\":12.9,\"temp_min\":13.91,\"temp_max\":13.91,\"pressure\":1016,\"sea_level\":1016,\"grnd_level\":1015,\"humidity\":59,\"temp_kf\":0},\"weather\":[{\"id\":803,\"main\":\"Clouds\",\"description\":\"broken clouds\",\"icon\":\"04d\"}],\"clouds\":{\"all\":73},\"wind\":{\"speed\":4.29,\"deg\":197,\"gust\":8.29},\"visibility\":10000,\"pop\":0,\"sys\":{\"pod\":\"d\"},\"dt_txt\":\"2021-10-24 15:00:00\"},{\"dt\":1635098400,\"main\":{\"temp\":12.24,\"feels_like\":11.56,\"temp_min\":12.24,\"temp_max\":12.24,\"pressure\":1016,\"sea_level\":1016,\"grnd_level\":1015,\"humidity\":78,\"temp_kf\":0},\"weather\":[{\"id\":803,\"main\":\"Clouds\",\"description\":\"broken clouds\",\"icon\":\"04n\"}],\"clouds\":{\"all\":72},\"wind\":{\"speed\":3.53,\"deg\":188,\"gust\":9.71},\"visibility\":10000,\"pop\":0,\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2021-10-24 18:00:00\"},{\"dt\":1635109200,\"main\":{\"temp\":13.1,\"feels_like\":12.76,\"temp_min\":13.1,\"temp_max\":13.1,\"pressure\":1015,\"sea_level\":1015,\"grnd_level\":1014,\"humidity\":88,\"temp_kf\":0},\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04n\"}],\"clouds\":{\"all\":100},\"wind\":{\"speed\":4.45,\"deg\":195,\"gust\":10.99},\"visibility\":10000,\"pop\":0.16,\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2021-10-24 21:00:00\"},{\"dt\":1635120000,\"main\":{\"temp\":12.02,\"feels_like\":11.68,\"temp_min\":12.02,\"temp_max\":12.02,\"pressure\":1015,\"sea_level\":1015,\"grnd_level\":1014,\"humidity\":92,\"temp_kf\":0},\"weather\":[{\"id\":803,\"main\":\"Clouds\",\"description\":\"broken clouds\",\"icon\":\"04n\"}],\"clouds\":{\"all\":74},\"wind\":{\"speed\":2.94,\"deg\":220,\"gust\":8.74},\"visibility\":10000,\"pop\":0.14,\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2021-10-25 00:00:00\"},{\"dt\":1635130800,\"main\":{\"temp\":10.77,\"feels_like\":10.28,\"temp_min\":10.77,\"temp_max\":10.77,\"pressure\":1015,\"sea_level\":1015,\"grnd_level\":1014,\"humidity\":91,\"temp_kf\":0},\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"clear sky\",\"icon\":\"01n\"}],\"clouds\":{\"all\":7},\"wind\":{\"speed\":2.88,\"deg\":234,\"gust\":8.54},\"visibility\":10000,\"pop\":0,\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2021-10-25 03:00:00\"},{\"dt\":1635141600,\"main\":{\"temp\":9.94,\"feels_like\":8.44,\"temp_min\":9.94,\"temp_max\":9.94,\"pressure\":1016,\"sea_level\":1016,\"grnd_level\":1015,\"humidity\":88,\"temp_kf\":0},\"weather\":[{\"id\":800,\"main\":\"Clear\",\"description\":\"clear sky\",\"icon\":\"01n\"}],\"clouds\":{\"all\":8},\"wind\":{\"speed\":3,\"deg\":231,\"gust\":9.64},\"visibility\":10000,\"pop\":0,\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2021-10-25 06:00:00\"},{\"dt\":1635152400,\"main\":{\"temp\":11.89,\"feels_like\":11.2,\"temp_min\":11.89,\"temp_max\":11.89,\"pressure\":1017,\"sea_level\":1017,\"grnd_level\":1017,\"humidity\":79,\"temp_kf\":0},\"weather\":[{\"id\":802,\"main\":\"Clouds\",\"description\":\"scattered clouds\",\"icon\":\"03d\"}],\"clouds\":{\"all\":25},\"wind\":{\"speed\":3.29,\"deg\":234,\"gust\":9.24},\"visibility\":10000,\"pop\":0,\"sys\":{\"pod\":\"d\"},\"dt_txt\":\"2021-10-25 09:00:00\"},{\"dt\":1635163200,\"main\":{\"temp\":15.44,\"feels_like\":14.74,\"temp_min\":15.44,\"temp_max\":15.44,\"pressure\":1017,\"sea_level\":1017,\"grnd_level\":1016,\"humidity\":65,\"temp_kf\":0},\"weather\":[{\"id\":500,\"main\":\"Rain\",\"description\":\"light rain\",\"icon\":\"10d\"}],\"clouds\":{\"all\":29},\"wind\":{\"speed\":4.75,\"deg\":237,\"gust\":7.24},\"visibility\":10000,\"pop\":0.26,\"rain\":{\"3h\":0.12},\"sys\":{\"pod\":\"d\"},\"dt_txt\":\"2021-10-25 12:00:00\"},{\"dt\":1635174000,\"main\":{\"temp\":15.52,\"feels_like\":14.67,\"temp_min\":15.52,\"temp_max\":15.52,\"pressure\":1017,\"sea_level\":1017,\"grnd_level\":1016,\"humidity\":59,\"temp_kf\":0},\"weather\":[{\"id\":500,\"main\":\"Rain\",\"description\":\"light rain\",\"icon\":\"10d\"}],\"clouds\":{\"all\":52},\"wind\":{\"speed\":3.54,\"deg\":255,\"gust\":7.2},\"visibility\":10000,\"pop\":0.44,\"rain\":{\"3h\":0.31},\"sys\":{\"pod\":\"d\"},\"dt_txt\":\"2021-10-25 15:00:00\"},{\"dt\":1635184800,\"main\":{\"temp\":13.15,\"feels_like\":12.4,\"temp_min\":13.15,\"temp_max\":13.15,\"pressure\":1019,\"sea_level\":1019,\"grnd_level\":1018,\"humidity\":72,\"temp_kf\":0},\"weather\":[{\"id\":803,\"main\":\"Clouds\",\"description\":\"broken clouds\",\"icon\":\"04n\"}],\"clouds\":{\"all\":76},\"wind\":{\"speed\":3.06,\"deg\":248,\"gust\":8.24},\"visibility\":10000,\"pop\":0.34,\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2021-10-25 18:00:00\"},{\"dt\":1635195600,\"main\":{\"temp\":11.93,\"feels_like\":11.29,\"temp_min\":11.93,\"temp_max\":11.93,\"pressure\":1019,\"sea_level\":1019,\"grnd_level\":1018,\"humidity\":81,\"temp_kf\":0},\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04n\"}],\"clouds\":{\"all\":100},\"wind\":{\"speed\":2.79,\"deg\":213,\"gust\":8.59},\"visibility\":10000,\"pop\":0,\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2021-10-25 21:00:00\"},{\"dt\":1635206400,\"main\":{\"temp\":12.2,\"feels_like\":11.77,\"temp_min\":12.2,\"temp_max\":12.2,\"pressure\":1018,\"sea_level\":1018,\"grnd_level\":1017,\"humidity\":88,\"temp_kf\":0},\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04n\"}],\"clouds\":{\"all\":100},\"wind\":{\"speed\":3.46,\"deg\":206,\"gust\":11.56},\"visibility\":10000,\"pop\":0,\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2021-10-26 00:00:00\"},{\"dt\":1635217200,\"main\":{\"temp\":12.9,\"feels_like\":12.41,\"temp_min\":12.9,\"temp_max\":12.9,\"pressure\":1018,\"sea_level\":1018,\"grnd_level\":1018,\"humidity\":83,\"temp_kf\":0},\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04n\"}],\"clouds\":{\"all\":100},\"wind\":{\"speed\":4.84,\"deg\":246,\"gust\":10.67},\"visibility\":10000,\"pop\":0,\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2021-10-26 03:00:00\"},{\"dt\":1635228000,\"main\":{\"temp\":11.89,\"feels_like\":11.22,\"temp_min\":11.89,\"temp_max\":11.89,\"pressure\":1019,\"sea_level\":1019,\"grnd_level\":1018,\"humidity\":80,\"temp_kf\":0},\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04n\"}],\"clouds\":{\"all\":99},\"wind\":{\"speed\":4.29,\"deg\":229,\"gust\":12.07},\"visibility\":10000,\"pop\":0,\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2021-10-26 06:00:00\"},{\"dt\":1635238800,\"main\":{\"temp\":13.46,\"feels_like\":12.87,\"temp_min\":13.46,\"temp_max\":13.46,\"pressure\":1019,\"sea_level\":1019,\"grnd_level\":1018,\"humidity\":77,\"temp_kf\":0},\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04d\"}],\"clouds\":{\"all\":98},\"wind\":{\"speed\":4.74,\"deg\":229,\"gust\":12.36},\"visibility\":10000,\"pop\":0,\"sys\":{\"pod\":\"d\"},\"dt_txt\":\"2021-10-26 09:00:00\"},{\"dt\":1635249600,\"main\":{\"temp\":16.71,\"feels_like\":16.34,\"temp_min\":16.71,\"temp_max\":16.71,\"pressure\":1019,\"sea_level\":1019,\"grnd_level\":1018,\"humidity\":73,\"temp_kf\":0},\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04d\"}],\"clouds\":{\"all\":99},\"wind\":{\"speed\":5.29,\"deg\":228,\"gust\":11.38},\"visibility\":10000,\"pop\":0,\"sys\":{\"pod\":\"d\"},\"dt_txt\":\"2021-10-26 12:00:00\"},{\"dt\":1635260400,\"main\":{\"temp\":17.04,\"feels_like\":16.78,\"temp_min\":17.04,\"temp_max\":17.04,\"pressure\":1018,\"sea_level\":1018,\"grnd_level\":1017,\"humidity\":76,\"temp_kf\":0},\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04d\"}],\"clouds\":{\"all\":100},\"wind\":{\"speed\":5.55,\"deg\":226,\"gust\":11.25},\"visibility\":10000,\"pop\":0,\"sys\":{\"pod\":\"d\"},\"dt_txt\":\"2021-10-26 15:00:00\"},{\"dt\":1635271200,\"main\":{\"temp\":14.97,\"feels_like\":14.79,\"temp_min\":14.97,\"temp_max\":14.97,\"pressure\":1019,\"sea_level\":1019,\"grnd_level\":1018,\"humidity\":87,\"temp_kf\":0},\"weather\":[{\"id\":804,\"main\":\"Clouds\",\"description\":\"overcast clouds\",\"icon\":\"04n\"}],\"clouds\":{\"all\":100},\"wind\":{\"speed\":5.63,\"deg\":225,\"gust\":13.25},\"visibility\":10000,\"pop\":0,\"sys\":{\"pod\":\"n\"},\"dt_txt\":\"2021-10-26 18:00:00\"}],\"city\":{\"id\":2643743,\"name\":\"London\",\"coord\":{\"lat\":51.5099,\"lon\":-0.1181},\"country\":\"GB\",\"population\":1000000,\"timezone\":3600,\"sunrise\":1634798081,\"sunset\":1634835310}}";
        String expected = "{\"weather\":[{\"day\":\"Friday\",\"temp\":11,\"chance_of_rain\":0,\"weather_type\":\"Broken clouds\",\"icon\":\"04d\"},{\"day\":\"Saturday\",\"temp\":13,\"chance_of_rain\":0,\"weather_type\":\"Broken clouds\",\"icon\":\"04d\"},{\"day\":\"Sunday\",\"temp\":14,\"chance_of_rain\":0,\"weather_type\":\"Overcast clouds\",\"icon\":\"04d\"},{\"day\":\"Monday\",\"temp\":15,\"chance_of_rain\":26,\"weather_type\":\"Light rain\",\"icon\":\"10d\"},{\"day\":\"Tuesday\",\"temp\":17,\"chance_of_rain\":0,\"weather_type\":\"Overcast clouds\",\"icon\":\"04d\"}]}";

        WeatherService weatherService = spy(new WeatherService());

        JsonObject mockedUnfilteredJsonObject = new Gson().fromJson(mockedResponseBodyString, JsonElement.class).getAsJsonObject();
        when(weatherService.fetchWeatherData(latitude, longitude)).thenReturn(mockedUnfilteredJsonObject);

        //act
        String actual = weatherService.getFiveDayForecast(latitude, longitude);

        //assert
        assertEquals(expected, actual);

    }

}