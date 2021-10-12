import React from "react";
import "bootstrap/dist/css/bootstrap.min.css";
import "./WeatherBar.css";
import WeatherTile from "./WeatherTile/WeatherTile";
import weatherData from "./weatherData.json";

const WeatherBar = () => {
  return (
    <div className="WeatherBar">
      {weatherData.weather.map((weather) => {
        return <WeatherTile data={weather} />;
      })}
    </div>
  );
};

export default WeatherBar;
