import EventsBar from "../EventsBar/EventsBar";
import WeatherBar from "../WeatherBar/WeatherBar";
import { Container } from "react-bootstrap"
import "./CandyStore.css"



import React, { useState, useEffect } from 'react'

const CandyStore = ({chosenLocation}) => {

	const [coords, setCoords] = useState({
		lat: 51.5072,
		lng: 0.1276,
	})

	useEffect(() => {
		if(chosenLocation) {

			setCoords(chosenLocation)
		}
	}, [chosenLocation])

	console.log(coords.lat, coords.lng);

	return (
		<Container >
			<p className= "bar-title">Weather</p>
			<WeatherBar lat={coords.lat} lng={coords.lng} />
			<p className= "bar-title">Events</p>
			<EventsBar lat={coords.lat} lng={coords.lng} />
		</Container>
	)
}

export default CandyStore
