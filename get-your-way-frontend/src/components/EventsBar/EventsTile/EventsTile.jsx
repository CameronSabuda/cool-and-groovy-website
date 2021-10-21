import React from 'react'
import Card from 'react-bootstrap/Card'
import { Button } from 'react-bootstrap'
import PropTypes from 'prop-types'
import './EventsTile.css'


const EventsTile = ({ data: { labels, title, start_date, end_date, distance_from_location, category } }) => {
	let [date, startTime] = start_date.split(' ')
	let endTime = end_date.split(' ')[1]

	return (
		<Card className='event-tile bg-primary shadow-lg text-center' style={{ minWidth: '12rem' }}>
			<span className='tag'>{labels[0]}</span>
			<Card.Img variant='top' className='mx-auto' src={`images/${category}.png`} />
			<Card.Body className='d-block pt-1'>
				<Card.Title className='text-white text-wrap'>{title}</Card.Title>
				<Card.Text className='text-white'>{date}</Card.Text>
				<Card.Text className='text-white'>
					{startTime.substring(0,5)} - {endTime.substring(0,5)}
				</Card.Text>
				<Card.Text className='text-white text-center'>
					{distance_from_location}
				</Card.Text>
				<div>
					<Button variant='secondary' size='sm' className='mb-2'>
						Find out more
					</Button>
				</div>
			</Card.Body>
		</Card>
	)
}

EventsTile.propTypes = {
	data: PropTypes.shape({
		labels: PropTypes.array,
		title: PropTypes.string.isRequired,
		start_date: PropTypes.string,
		end_date: PropTypes.string,
		distance_from_location: PropTypes.string,
		category: PropTypes.string,
	}),
}

export default EventsTile
