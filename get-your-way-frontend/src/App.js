import "./App.css";
import React from "react";
import WeatherBar from "./components/WeatherBar/WeatherBar.jsx";
import Footer from "./components/Footer/Footer.jsx";

function App() {
  return (
    <div className="App">
      <WeatherBar />
      <Footer />
    </div>
  );
}

export default App;
