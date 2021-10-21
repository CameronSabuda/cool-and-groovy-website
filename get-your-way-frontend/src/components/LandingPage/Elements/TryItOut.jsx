import React from 'react'
import { Container, Row, Col, Card } from 'react-bootstrap'
import { Link } from 'react-router-dom'

const styles = {
	maxHeight: '30%',
	maxWidth: '75%',
}

const TryItOut = () => {
	return (
		<div id='try-it-out' className='bg-light py-5'>
			<Container>
				<Row>
					<h1>Movies to try out</h1>
					<p>
						Try our website out, and click on a movie that
						you&apos;re interested in down below.
					</p>
					<p>
						You&apos;ll be taken to a page to see all the filming
						locations, and related information of the area!
					</p>
				</Row>
				<Row className='d-flex align-items-center justify-content-center gy-3'>
					<Col md={4} sm={12} className='text-center' style={styles}>
						<Card
							as={Link}
							to={`/map/harryPotter`}
							className='shadow-lg text-center border-0'>
							<Card.Img src={`./images/harry-potter.jpeg`} />
							<Card.ImgOverlay className='text-white'>
								<Card.Title>
									Harry Potter and The Deathly Hallows
								</Card.Title>
							</Card.ImgOverlay>
						</Card>
					</Col>
					<Col md={4} sm={12} className='text-center' style={styles}>
						<Card
							as={Link}
							to={`/map/captainAmerica`}
							className='shadow-lg text-center border-0'>
							<Card.Img src={`./images/captain-america.jpeg`} />
							<Card.ImgOverlay className='text-white'>
								<Card.Title>Captain America</Card.Title>
							</Card.ImgOverlay>
						</Card>
					</Col>
					<Col md={4} sm={12} className='text-center' style={styles}>
						<Card
							as={Link}
							to={`/map/chernobyl`}
							className='shadow-lg text-center border-0'>
							<Card.Img src={`./images/chernobyl.jpeg`} />
							<Card.ImgOverlay className='text-white'>
								<Card.Title>Chernobyl</Card.Title>
							</Card.ImgOverlay>
						</Card>
					</Col>
				</Row>
			</Container>
		</div>
	)
}

export default TryItOut
