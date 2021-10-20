import EventsBar from "../EventsBar/EventsBar";
import WeatherBar from "../WeatherBar/WeatherBar";
import { Container } from "react-bootstrap"
import "./CandyStore.css"



import React from 'react'

const CandyStore = ({chosenLocation: {lat, lng}}) => {

	console.log(lat, lng);

	return (
		<Container >
			<p className= "bar-title">Weather</p>
			<WeatherBar lat={lat} lng={lng} />
			<p className= "bar-title">Events</p>
			<EventsBar lat={lat} lng={lng} />
		</Container>
	)
}

export default CandyStore
