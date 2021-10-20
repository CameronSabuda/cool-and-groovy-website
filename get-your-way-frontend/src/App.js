import './App.css'
import React from 'react'
import data from './movies.json'

import NavigationBar from './components/NavigationBar/NavigationBar.jsx'
import LandingPage from './components/LandingPage/index.jsx'
import Footer from './components/Footer/Footer'
import MoviePage from './components/MovieListPage/Elements/MovieList'
import LocationsPage from './components/LocationsPage/LocationsPage'
import NotFoundPage from './components/Error/NotFoundPage'
import SignUp from './components/SignUp/SignUp'

import { Switch, Route, useRouteMatch } from 'react-router-dom'

function App() {

	const match = useRouteMatch('/map/:name')
	const locations = match ? data.movies.find((movie) => movie.name === (match.params.name)).locations : null

	return (
		<div>
			<NavigationBar />
			<Switch>
				<Route path='/' component={LandingPage} exact />
				<Route path='/movies'>
					<MoviePage/>
				</Route>
				<Route path='/signUp' component={SignUp} />
				<Route path='/map/:name'>
					<LocationsPage locations={locations}/>
				</Route>
				<Route path='/map'>
					<LocationsPage />
				</Route>
				<Route component={NotFoundPage} />
			</Switch>
			<Footer />
		</div>
	)
}

export default App
