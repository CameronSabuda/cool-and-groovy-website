import React, { useEffect, useState } from 'react'
import axios from 'axios'
import WeatherTile from './WeatherTile/WeatherTile'
import "./WeatherBar.css";
import Loader from '../Loader/Loader'
import { Container, Row } from 'react-bootstrap'

const client = axios.create({
	baseURL: 'http://99.81.186.138:9090/weather?latitude=51.5074&longitude=-0.1278',
})

const WeatherBar = () => {
	const [weatherData, setWeatherData] = useState()
	const [isLoading, setLoading] = useState(true)

	useEffect(() => {
		const getWeather = async () => {
			let response = await client.get()
			let { weather } = response.data
			setWeatherData(weather)
			setLoading(false)
		}
		getWeather()
	}, [])

	return (
		<div className='WeatherBar bg-secondary vw-100'>
			<Container fluid>
				<Row className='d-flex flex-row scrolling'>
					{isLoading && <Loader />}
					{weatherData &&
						weatherData.map((weather, i) => {
							return <WeatherTile key={i} data={weather} />
						})}
				</Row>
			</Container>
		</div>
	)
}

export default WeatherBar;
