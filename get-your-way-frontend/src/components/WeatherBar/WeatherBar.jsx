import React, { useEffect, useState } from "react";
import "./WeatherBar.css";
import WeatherTile from "./WeatherTile/WeatherTile";
import axios from "axios";

const client = axios.create({
  baseURL:
    "http://99.81.186.138:9090/weather?latitude=51.5074&longitude=-0.1278"
  // baseURL: "http://localhost:9090/weather?latitude=51.5074&longitude=-0.1278"
});

const WeatherBar = () => {
  const [weatherData, setWeatherData] = useState();

  useEffect(() => {
    const getWeather = async () => {
      let response = await client.get();
      let { weather } = response.data;
      setWeatherData(weather);
    };
    getWeather();
  }, []);

  return (
    <div className="WeatherBar">
      {weatherData &&
        weatherData.map((weather, i) => {
          return <WeatherTile key={i} data={weather} />;
        })}
    </div>
  );
};

export default WeatherBar;
