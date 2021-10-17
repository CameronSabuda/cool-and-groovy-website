import "./App.css";
import React from "react";
import WeatherBar from "./components/WeatherBar/WeatherBar.jsx";
import Footer from "./components/Footer/Footer.jsx";
import NavigationBar from "./components/NavigationBar/NavigationBar.jsx";

function App() {
  return (
    <div className="App">
      <NavigationBar />
      <WeatherBar />
      <Footer />
    </div>
  );
}

export default App;
