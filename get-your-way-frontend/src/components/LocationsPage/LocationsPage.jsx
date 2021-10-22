import React, { useState } from 'react'
import { Container, Row, Col } from 'react-bootstrap'
import CandyStore from '../CandyStore/CandyStore'
import './LocationsPage.css'
import Map2 from '../Map2/Map2'

const LocationsPage = ({ locations}) => {
	const [chosenLocation, setChosenLocation] = useState({})


	return (
		<Container fluid>
			<Row>
				<Col className='mx-3 my-5'>
				<p className= "bar-title">Please click on a marker</p>
					<Map2 locations={locations} setChosenLocation={setChosenLocation} />
				</Col>
				<Col sm={4}>
					<CandyStore
						chosenLocation={chosenLocation}
					/>
				</Col>
			</Row>
		</Container>
	)
}

export default LocationsPage
