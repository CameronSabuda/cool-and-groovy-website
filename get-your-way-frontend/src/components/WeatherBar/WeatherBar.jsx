import React, { useEffect, useState } from "react";
import "./WeatherBar.css";
import WeatherTile from "./WeatherTile/WeatherTile";
import axios from 'axios'


// use this command Json-server -p 4000 --watch ./src/FakeData.json
const client = axios.create({
  baseURL: "http://localhost:4000/weather"
})

const WeatherBar = () => {
  const [weatherData, setWeatherData] = useState([])

  useEffect(() => {
    const getWeather = async () => {
      let response = await client.get()
      setWeatherData(response.data)
    }
    getWeather()
  }, [])

  return(
    <div className="WeatherBar">
      {weatherData.map((weather, i) => {
        console.log(weather);
        return <WeatherTile key={i} data={weather}/>
      })}
    </div>
  )


  // return (
  //   <div className="WeatherBar">
  //     {weatherData.weather.map((weather) => {
  //       return <WeatherTile data={weather} />;
  //     })}
  //   </div>
  // );
};

export default WeatherBar;
