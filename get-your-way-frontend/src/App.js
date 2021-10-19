import "./App.css";
import React from "react";
import WeatherBar from "./components/WeatherBar/WeatherBar.jsx";
import Footer from "./components/Footer/Footer.jsx";
import EventsBar from "./components/EventsBar/EventsBar";
import NavigationBar from "./components/NavigationBar/NavigationBar.jsx";
import { BrowserRouter as Router } from "react-router-dom";
import MovieListPage from "./components/MovieListPage/index.jsx";

function App() {
	return (
		<div className='App'>
			<Router>
				<MovieListPage />
			</Router>
		</div>
	);
}

export default App;
