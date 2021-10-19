import React from 'react'
import Card from 'react-bootstrap/Card'
import './WeatherTile.css'
import { Row, Col, Container } from 'react-bootstrap'
import PropTypes from 'prop-types'

const WeatherTile = ({ data: { day, temp, weather_type, chance_of_rain, icon } }) => {
	return (
		<Card className='bg-primary bg-gradient m-2 shadow-lg text-center' style={{ minWidth: '18rem' }}>
			<Card.Header className='text-white bg-primary-alt'>{day}</Card.Header>
			<Card.Img variant="top" className="mx-auto" src={`http://openweathermap.org/img/wn/${icon}@2x.png`} />


			<Card.Body className=''>
				<Container>
					{/* <Row>
						<img src={`http://openweathermap.org/img/wn/${icon}@2x.png`} alt='Type of weather' />
					</Row> */}
					<Row>
						<Card.Text className='temperature-text text-orange-200'>{temp}°C</Card.Text>
					</Row>
					{/* Chance of rain */}

					<Row className='d-flex flex-row text-orange-100 justify-content-between mx-2'>
						<Col className='align-self-center'>
							{weather_type}
						</Col>
						<Col className="d-flex align-items-center">
							<label  htmlFor='cloud-icon'>
								{chance_of_rain}%
							</label>
							<img id='cloud-icon' src='http://openweathermap.org/img/wn/09d.png' alt='' />
						</Col>
					</Row>

				</Container>
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
