import React from "react";
import "bootstrap/dist/css/bootstrap.min.css";
import "./WeatherBar.css";
import WeatherTile from "./WeatherTile/WeatherTile";

const WeatherBar = () => {
  const days = ["Monday", "Tuesday", "Wednesday", "Thursday", "Friday"];

  return (
    <div className="WeatherBar">
      {days.map((day) => {
        return <WeatherTile day={day} />;
      })}
    </div>
  );
};

export default WeatherBar;
