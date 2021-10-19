import "./App.css";
import React from "react";

import NavigationBar from "./components/NavigationBar/NavigationBar.jsx";
import { BrowserRouter as Router } from "react-router-dom";
import LandingPage from "./components/LandingPage/index.jsx";
import Footer from "./components/Footer/Footer";

function App() {
	return (
		<div className='App'>
			<Router>
				<NavigationBar />
				<LandingPage />
				<Footer />
			</Router>
			
		</div>
	);
}

export default App;
