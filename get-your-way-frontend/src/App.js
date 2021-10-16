import "./App.css";
import React from "react";
import WeatherBar from "./components/WeatherBar/WeatherBar.jsx";
import NavigationBar from "./components/NavigationBar/NavigationBar.jsx";

function App() {
  return (
    <div className="App">
      <NavigationBar />
      <WeatherBar />
    </div>
  );
}

export default App;
