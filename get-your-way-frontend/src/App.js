import "./App.css";
import React from "react";
import WeatherBar from "./components/WeatherBar/WeatherBar.jsx";
import Footer from "./components/Footer/Footer.jsx";
import EventsBar from './components/EventsBar/EventsBar';

function App() {
  return (
    <div className="App">
      <WeatherBar />
      <EventsBar />
      <Footer />
    </div>
  );
}

export default App;
