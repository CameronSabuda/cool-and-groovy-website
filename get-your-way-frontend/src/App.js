import "./App.css";
import React from "react";

import NavigationBar from "./components/NavigationBar/NavigationBar.jsx";
import WeatherBar from "./components/WeatherBar/WeatherBar.jsx";
import EventsBar from './components/EventsBar/EventsBar';
import Footer from "./components/Footer/Footer.jsx";
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
