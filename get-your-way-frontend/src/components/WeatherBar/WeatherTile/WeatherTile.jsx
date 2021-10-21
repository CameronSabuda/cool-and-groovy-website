import React from 'react'
import Card from 'react-bootstrap/Card'
import './WeatherTile.css'
import { Image } from 'react-bootstrap'
import PropTypes from 'prop-types'

const WeatherTile = ({ data: { day, temp, weather_type, chance_of_rain, icon } }) => {
	return (
		<Card className='weather-tile bg-primary bg-gradient m-2 shadow-lg text-center' style={{ minWidth: '9rem' }}>
			<Card.Header className='text-white bg-primary-alt'>{day}</Card.Header>
			<Card.Img variant="top" className="mx-auto weather-image" src={`http://openweathermap.org/img/wn/${icon}@4x.png`} />


			<Card.Body className= 'h-12 d-inline-block'>
				<div>
					{/* <Row>
						<img src={`http://openweathermap.org/img/wn/${icon}@2x.png`} alt='Type of weather' />
					</Row> */}
					<div>
						<Card.Text className='temperature-text text-orange-200'>{temp}°C</Card.Text>
					</div>
					{/* Chance of rain */}

					<div className='text-orange-100'>
						<div className='align-items-center' sm={2}>
							<Card.Text className="weather-type-text">{weather_type}</Card.Text>
						</div>
						</div>
						<div>
						<div className="align-items-center">
							<label htmlFor='cloud-icon'>
								{chance_of_rain}%
							</label>
							<Image id='cloud-icon' src='http://openweathermap.org/img/wn/09d.png' alt='' fluid/>
						</div>
					</div>

				</div>
			</Card.Body>
		</Card>
	)
}

WeatherTile.propTypes = {
	data: PropTypes.shape({
		date: PropTypes.number,
		day: PropTypes.string.isRequired,
		temp: PropTypes.number,
		chance_of_rain: PropTypes.number,
		weather_type: PropTypes.string,
		icon: PropTypes.string,
	}),
}

// requiredFunc: PropTypes.func.isRequired,
export default WeatherTile
