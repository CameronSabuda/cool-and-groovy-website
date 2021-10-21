import React, { useEffect, useState } from 'react'
import axios from 'axios'
import WeatherTile from './WeatherTile/WeatherTile'
import './WeatherBar.css'
import Loader from '../Loader/Loader'
import { Container, CardGroup } from 'react-bootstrap'

const WeatherBar = ({ lat, lng }) => {
	const [weatherData, setWeatherData] = useState()
	const [isLoading, setLoading] = useState(true)

	const client = axios.create({
		baseURL: `http://99.81.186.138:9090/weather?latitude=${lat}&longitude=${lng}`,
	})

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
		<div className='WeatherBar bg-secondary px-2 py-3'>
			<Container>
				<CardGroup className='d-flex flex-row flex-nowrap scrolling'>
					{isLoading && <Loader />}
					{weatherData &&
						weatherData.map((weather, i) => {
							return <WeatherTile key={i} data={weather} />
						})}
				</CardGroup>
			</Container>
		</div>
	)
}

export default WeatherBar
