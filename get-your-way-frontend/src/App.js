import './App.css'
import React from 'react'

import NavigationBar from './components/NavigationBar/NavigationBar.jsx'
import LandingPage from './components/LandingPage/index.jsx'
import Footer from './components/Footer/Footer'
import MoviePage from './components/MovieListPage/index'
// import LocationsPage from './components/LocationsPage/LocationsPage'
import NotFoundPage from './components/Error/NotFoundPage'
import SignUp from './components/SignUp/SignUp'

import { Switch, Route } from 'react-router-dom'

function App() {
	return (
		<div>
			<NavigationBar />
			<Switch>
				<Route path='/' component={LandingPage} exact />
				<Route path='/movies' component={MoviePage} />
				<Route path='/signUp' component={SignUp} />
				<Route component={NotFoundPage} />
			</Switch>

			<Footer />
		</div>
	)
}

export default App
