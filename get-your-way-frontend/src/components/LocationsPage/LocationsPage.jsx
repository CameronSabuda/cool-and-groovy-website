import React, { useState } from 'react'
import { Container, Row, Col } from 'react-bootstrap'
import CandyStore from '../CandyStore/CandyStore'
import './LocationsPage.css'
// import Map from '../Map/Map'
import Map2 from '../Map2/Map2'

const LocationsPage = ({ locations }) => {
	const [chosenLocation, setChosenLocation] = useState(null)

	const defaultLocation = {
		lat: 51.5072,
		lng: 0.1276,
	}

	return (
		<Container fluid>
			<Row>

				<Col className='mx-3 my-5'>
					<Map2 locations={locations} setChosenLocation={setChosenLocation} />
				</Col>
				<Col sm={4}>
					<CandyStore
						chosenLocation={chosenLocation || defaultLocation}
					/>
				</Col>
			</Row>
		</Container>
	)
}

export default LocationsPage
