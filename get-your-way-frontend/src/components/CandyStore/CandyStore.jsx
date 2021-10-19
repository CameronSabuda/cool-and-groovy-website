import EventsBar from "../EventsBar/EventsBar";
import WeatherBar from "../WeatherBar/WeatherBar";
import { Container } from "react-bootstrap"
import "./CandyStore.css"



import React from 'react'

const CandyStore = () => {
	return (
		<Container >
			<p className= "bar-title">Weather</p>
			<WeatherBar />
			<p className= "bar-title">Events</p>
			<EventsBar />	
		</Container>
	)
}

export default CandyStore
