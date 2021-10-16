import React from 'react'
import Card from 'react-bootstrap/Card'
import { Row, Col, Container, Button } from 'react-bootstrap'
import PropTypes from 'prop-types'
import './EventsTile.css'

const handleError = (e) => {
	e.target.src = 'images/fire.png'
}

const EventsTile = ({ data: { labels, title, start_date, end_date, distance_from_location, category } }) => {
	let [date, startTime] = start_date.split(' ')
	let endTime = end_date.split(' ')[1]

	return (
		<Card className='bg-primary my-5 mx-2 shadow-lg text-center' style={{ minWidth: '20rem' }}>
			<span className='tag'>{labels[0]}</span>
			<Card.Img variant='top' className='mx-auto' src={`images/${category}.png`} onError={handleError} />
			<Card.Body className='d-block pt-1'>
				<Container className='h-50 mb-3'>
					<Card.Title className='text-white mb-2 text-wrap'>{title}</Card.Title>
					<Card.Text className='text-white'>{date}</Card.Text>
				</Container>
				<Container fluid>
					<Row className='d-flex justify-content-between'>
						{/* Col 1 */}
						<Col className='text-white'>
							<Row>
								<p className=''>{startTime}</p>
								<p>{endTime}</p>
							</Row>
						</Col>
						{/* Col 2 */}
						<Col className='text-white '>
							<Row>
								<Button variant='secondary' size='sm' className='mb-2'>
									{' '}
									Find out more{' '}
								</Button>
							</Row>
							<Row className='text-center'>
								<p className='p-0 m-0'>{distance_from_location}</p>
							</Row>
						</Col>
					</Row>
				</Container>
			</Card.Body>
		</Card>
	)
}

EventsTile.propTypes = {
	labels: PropTypes.string,
	title: PropTypes.string.isRequired,
	start_date: PropTypes.string,
	end_date: PropTypes.string,
	distance_from_location: PropTypes.string,
}

export default EventsTile
