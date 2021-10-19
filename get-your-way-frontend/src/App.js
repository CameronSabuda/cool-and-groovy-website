// import 'bootstrap/dist/css/bootstrap.min.css'
import "./App.css";
import React from "react";

import Footer from "./components/Footer/Footer.jsx";
import NavigationBar from "./components/NavigationBar/NavigationBar.jsx";
import { BrowserRouter as Router } from "react-router-dom";
import LocationsPage from "./components/LocationsPage/LocationsPage";

function App() {
  return (
    <div className="App">

      <Router>
        <NavigationBar />
        <LocationsPage />
        <Footer />
      </Router>
    </div>
  );

}

export default App;
