import EventsBar from "../EventsBar/EventsBar";
import WeatherBar from "../WeatherBar/WeatherBar";
import "./CandyStore.css"



import React from 'react'

const CandyStore = () => {
	return (
		<div className= "candystore">
			<p className= "bar-title">Weather</p>
			<WeatherBar />
			<p className= "bar-title">Events</p>
			<EventsBar />	
		</div>
	)
}

export default CandyStore
