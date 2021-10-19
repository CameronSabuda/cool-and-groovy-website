import React from 'react'
import { Container, Row, Col} from 'react-bootstrap'
import CandyStore from '../CandyStore/CandyStore'
import './LocationsPage.css'

const LocationsPage = () => {
	return (
		
			<Container fluid>
				<Row >
					<Col sm={7}>
						map goes here
					</Col>
					<Col sm={5}>
						<CandyStore />
					</Col>
				</Row>
			</Container>
		

		
	)
}

export default LocationsPage
