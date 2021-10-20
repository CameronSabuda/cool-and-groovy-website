import React, {useState, useEffect} from 'react'
import { Container, Row, Col} from 'react-bootstrap'
import CandyStore from '../CandyStore/CandyStore'
import './LocationsPage.css'
import Map from '../Map/Map'



const LocationsPage = () => {

	const [chosenLocation, setChosenLocation] = useState();

	const getLocationFromMap = (location) => {
		setChosenLocation(location)
	}

	useEffect(() => {
		console.log(chosenLocation)
		return () => {
			//
		}
	}, [chosenLocation])

	return (
		
			<Container fluid>
				<Row >
					<Col sm={7}>
						<div>
						<Map onClick={getLocationFromMap}/>
						</div>
					</Col>
					<Col sm={5}>
						<CandyStore location={chosenLocation}/>
					</Col>
				</Row>
			</Container>
		

		
	)
}

export default LocationsPage
