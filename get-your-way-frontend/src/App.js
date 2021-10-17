
import React from "react";
import Footer from "./components/Footer/Footer.jsx";
import NavigationBar from "./components/NavigationBar/NavigationBar.jsx";
import WeatherBar from './components/WeatherBar/WeatherBar.jsx';
import EventsBar from './components/EventsBar/EventsBar';


function App() {
  return (
    <div className="App">
      <NavigationBar />
      <WeatherBar />
      <Footer />
      <EventsBar />
    </div>
  );
}

export default App;
