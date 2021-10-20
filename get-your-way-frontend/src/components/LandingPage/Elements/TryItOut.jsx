import React from 'react'
import { Container, Row, Col, Image } from 'react-bootstrap'


const styles = {
	maxHeight: '30%',
	maxWidth: '75%',
}

const TryItOut = () => {
	return (
		<div id="try-it-out" className='bg-light py-5'>
			<Container>
				<Row>
					<h1>Movies to try out</h1>
					<p>
						Try our website out, and click on a movie that you're interested in down below.
					</p>
					<p>
						You'll be taken to a page to see all the filming locations, and related information of the area!
					</p>
				</Row>
				<Row className='d-flex align-items-center justify-content-center gy-3'>
					<Col md={4} sm={12} className="text-center" style={styles}>
						<Image src={'images/harry-potter.jpeg'} rounded fluid />
					</Col>
					<Col md={4} sm={12} className="text-center" style={styles}>
						<Image src={'images/captain-america.jpeg'} rounded fluid />
					</Col>
					<Col md={4} sm={12} className="text-center" style={styles}>
						<Image src={'images/chernobyl.jpeg'} rounded fluid />
					</Col>
				</Row>
			</Container>
		</div>
	)
}

export default TryItOut
