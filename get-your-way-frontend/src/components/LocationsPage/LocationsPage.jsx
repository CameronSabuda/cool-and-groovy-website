import React from 'react'
import { Container, Row, Col} from 'react-bootstrap'
import CandyStore from '../CandyStore/CandyStore'
import './LocationsPage.css'

const LocationsPage = ({locations}) => {
	return (

			<Container id="locations-container" className="" fluid>
				<Row >
					<Col sm={7}>
						map goes here
						{console.table(locations)}
					</Col>
					<Col sm={5}>
						<CandyStore />
					</Col>
				</Row>
			</Container>



	)
}

export default LocationsPage
