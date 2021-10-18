import "./App.css";
import React from "react";
import WeatherBar from "./components/WeatherBar/WeatherBar.jsx";
import Footer from "./components/Footer/Footer.jsx";
import EventsBar from './components/EventsBar/EventsBar';
import NavigationBar from "./components/NavigationBar/NavigationBar.jsx";
import { BrowserRouter as Router } from "react-router-dom";

function App() {
  return (
    <div className="App">

      <Router>
        <NavigationBar />
        <WeatherBar />
        <EventsBar />
        <Footer />
      </Router>
    </div>
  );
}

export default App;
