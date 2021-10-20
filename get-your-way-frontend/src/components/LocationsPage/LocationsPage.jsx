import React, {useState, useEffect} from 'react'
import { Container, Row, Col} from 'react-bootstrap'
import CandyStore from '../CandyStore/CandyStore'
import './LocationsPage.css'
// import Map from '../Map/Map'
import Map2 from '../Map2/Map2'



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
					{/* <Col sm={7}>
						<div>
						<Map onClick={getLocationFromMap}/>
						</div>
					</Col> */}
					<Col sm={5}>
						<CandyStore location={chosenLocation}/>
					</Col>
				</Row>

				<Row>
					<Col>
					<Map2 />
					</Col>
				</Row>
			</Container>



	)
}

export default LocationsPage
