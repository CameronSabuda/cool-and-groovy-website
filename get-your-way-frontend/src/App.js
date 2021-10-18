import "./App.css";
import React from "react";
import { BrowserRouter as Router } from "react-router-dom";

// import NavigationBar from "./components/NavigationBar/NavigationBar.jsx";
// import WeatherBar from "./components/WeatherBar/WeatherBar.jsx";
// import EventsBar from "./components/EventsBar/EventsBar";
// import Footer from "./components/Footer/Footer.jsx";
import LandingPage from "./components/LandingPage/index.jsx";

function App() {
	return (
		<div className='App'>
			<Router>
        <LandingPage />
      </Router>
		</div>
	);
}

export default App;
